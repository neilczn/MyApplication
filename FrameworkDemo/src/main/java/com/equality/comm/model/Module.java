package com.equality.comm.model;

/**
 * Created by neil on 2017/5/14.
 * 主页面中的模块
 */

public class Module {

    /**
     * 模块名称
     */
    private String name;
    /**
     * 模块对应的图片Id
     */
    private int imageId;

    /**
     *
     * @param name 模块名称
     * @param imageId 模块对应的图片Id
     */
    public Module(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    /**
     *
     * @return 模块名称
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name 模块名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return 模块对应的图片Id
     */
    public int getImageId() {
        return imageId;
    }

    /**
     *
     * @param imageId 模块对应的图片Id
     */
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
