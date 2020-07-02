package vip.wulang.test.springboot;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import vip.wulang.test.spring.Config;

import java.util.function.Predicate;

public class CusImpl implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                Config.class.getName()
        };
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
