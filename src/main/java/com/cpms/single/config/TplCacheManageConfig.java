package com.cpms.single.config;

import com.cpms.framework.common.utils.CsCollectionUtil;
import com.cpms.framework.common.utils.CsFileUtil;
import com.cpms.single.common.enums.TplGenParamEnum;
import com.google.common.collect.Maps;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: gulang
 * @time: 2022/1/19 16:47
 */
@Component
@Slf4j
public class TplCacheManageConfig {
    private static final String FILE_SEP = File.separator;

    // 模板文件加入内存减少反复io文件读取
    public static Map<String, File> genProjectTplFile = Maps.newConcurrentMap();
    public static Map<String, File> genFunTplFile = Maps.newConcurrentMap();

    @PostConstruct
    public void init(){
        for(TplGenParamEnum.TemplateTypeEnum  templateTypeEnum: TplGenParamEnum.TemplateTypeEnum.values()){
            try {
                initCacheTplFile(templateTypeEnum);
            } catch (Exception e) {
                log.error("initTplFileCache:fail!", e);
            }
        }
    }

    @SneakyThrows
    private void initCacheTplFile(TplGenParamEnum.TemplateTypeEnum templateTypeEnum){
        String basePath = FILE_SEP+"templates"+FILE_SEP+templateTypeEnum.getCode();
        String tplPath = null;
        List<File> files;
        String os = System.getProperty("os.name");
        if (os != null && os.toLowerCase().startsWith("windows")) {
            tplPath = System.getProperty("user.dir") + FILE_SEP + "src"+ FILE_SEP+"main"+ FILE_SEP+"resources" + basePath;
        } else if (os != null && os.toLowerCase().startsWith("linux")) {
            tplPath = basePath;
        }
        log.info("下模板根路径：tplPath={}", tplPath);
        files = CsFileUtil.loopFiles(tplPath);
        if(!CsCollectionUtil.isEmpty(files)) {
            for (File file : files) {
                int index = file.getAbsolutePath().lastIndexOf(templateTypeEnum.getCode());
                String filePath = file.getAbsolutePath().substring(index+templateTypeEnum.getCode().length() + 1);
                templateTypeEnum.getTplFilePathMap().put(filePath,file);
            }
        }
    }
}
