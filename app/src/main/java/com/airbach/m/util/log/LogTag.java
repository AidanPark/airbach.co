package com.airbach.m.util.log;

/**
 * <p>{@link Log} 에서 사용하기 위한 tag.
 *
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */
public class LogTag {

    public String name;
    public String simpleName;
    public Thread thread;

    public LogTag(String name, String simpleName, Thread thread) {
        this.name = name;
        this.simpleName = simpleName;
        this.thread = thread;
    }

    @Override
    public String toString() {
        return name;
    }
}
