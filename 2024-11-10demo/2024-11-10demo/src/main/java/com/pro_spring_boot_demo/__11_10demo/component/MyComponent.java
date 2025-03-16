package com.pro_spring_boot_demo.__11_10demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyComponent {
    Logger logger = LoggerFactory.getLogger(MyComponent.class);

    @Autowired
    public MyComponent(ApplicationArguments args) {
        boolean enable = args.containsOption("enable");
        if (enable) {
            logger.info("you are enabled");
            List<String> nonOptionArgs = args.getNonOptionArgs();
            if (!nonOptionArgs.isEmpty()) {
                for (String nonOptionArg : nonOptionArgs) {
                    logger.info("this is ".concat(nonOptionArg));
                }
            }
        }
    }
}
