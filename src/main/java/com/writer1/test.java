package com.writer1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test {
    public static void main(String[] args){
        Logger log = LoggerFactory.getLogger(test.class);
        log.trace("trace level");
        log.debug("debug level");
        log.info("info level");
        log.error("error level");
    }
}
