package com.contract.util.copy;

import com.contract.util.exception.ActException;
import com.contract.util.exception.ErrorCode;
import com.github.pagehelper.Page;
//import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListCopyTool {
    public static List copyTo(List fromList, Class toClass) {
        try {
            List toList = new ArrayList();
            if(null == fromList){
                return toList;
            }
            Object tempObj;
            for (Object aFromList : fromList) {
                tempObj = toClass.newInstance();
                BeanUtils.copyProperties(aFromList, tempObj, toClass);
                toList.add(tempObj);
            }
            if (fromList instanceof Page) {
                fromList.clear();
                fromList.addAll(toList);
                return fromList;
            } else {
                return toList;
            }
        } catch (Exception e) {
            throw new ActException(ErrorCode.LIST_COPY_ERROR.getCode(), ErrorCode.LIST_COPY_ERROR.getName());
        }
    }
    //踢除重复元素
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}
