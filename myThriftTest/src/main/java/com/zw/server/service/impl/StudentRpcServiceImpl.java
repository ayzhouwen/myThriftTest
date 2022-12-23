package com.zw.server.service.impl;

import cn.hutool.json.JSONUtil;
import com.zw.common.entity.thrift.TStudent;
import com.zw.common.service.thrift.IStudentRPCService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StudentRpcServiceImpl implements IStudentRPCService.Iface {
    @Override
    public List<TStudent> getStudentList() throws TException {

        List<TStudent> list=new ArrayList<>();
        TStudent s1=new TStudent();
        s1.setId(100L);
        s1.setName("张三");
        TStudent s2=new TStudent();
        s2.setId(200L);
        s2.setName("李四");
        list.add(s1);
        list.add(s2);
        log.info(JSONUtil.toJsonStr(list));
        return list;
    }

    @Override
    public TStudent getStudentInfo(long id) throws TException {
        if (id==100){
            TStudent s1=new TStudent();
            s1.setId(100L);
            s1.setName("张三");
            return s1;
        }
        return null;
    }
}
