package com.zw.client;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.zw.common.entity.thrift.TStudent;
import com.zw.common.service.thrift.IStudentRPCService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.List;

public class ClientBoot {
    public static void main(String[] args) throws Exception {
        TTransport transport = null;
        try {
            transport = new TSocket("10.168.136.128", 9999, 60*1000);
            TProtocol protocol = new TBinaryProtocol(transport);
            IStudentRPCService.Client client = new IStudentRPCService.Client(protocol);
            transport.open();
            for (int i = 0; i < 10; i++) {
                List<TStudent> list = client.getStudentList();
                System.out.println("Result =: " + JSONUtil.toJsonStr(list));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }
}
