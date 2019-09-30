package com.fgrapp.blog.blogserver.common.util;

import com.fgrapp.blog.blogserver.sys.entity.Dept;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DeptTree
 *
 * @author FGR on 2019/9/28
 */
@Data
public class DeptTree<T> implements Serializable {

    private static final long serialVersionUID = -9104099951163814433L;

    private String id;
    private String icon;
    private String href;
    private String name;
    private Map<String, Object> state;
    private boolean checked = false;
    private Map<String, Object> attributes;
    private List<DeptTree<T>> children;
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChild = false;

    private Dept data;

    public void initChildren(){
        this.children = new ArrayList<>();
    }

}
