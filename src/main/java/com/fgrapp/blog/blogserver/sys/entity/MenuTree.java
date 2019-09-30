package com.fgrapp.blog.blogserver.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MenuTree
 *
 * @author FGR on 2019/9/28
 */
@Data
public class MenuTree<T> implements Serializable {

    private static final long serialVersionUID = 6375074419358198778L;

    private String id;
    private String icon;
    private String href;
    private String title;
    private Map<String, Object> state;
    private boolean checked = false;
    private Map<String, Object> attributes;
    private List<MenuTree<T>> childs = new ArrayList<>();
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChild = false;

    private Menu data;

}
