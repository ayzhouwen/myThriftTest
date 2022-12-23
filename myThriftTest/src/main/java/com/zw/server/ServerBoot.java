package com.zw.server;

import com.zw.common.service.thrift.IStudentRPCService;
import com.zw.server.service.impl.StudentRpcServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import java.net.ServerSocket;

public class ServerBoot {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        TServerSocket serverTransport = new TServerSocket(serverSocket);
        IStudentRPCService.Processor processor =
                new IStudentRPCService.Processor<IStudentRPCService.Iface>(new StudentRpcServiceImpl());
        TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
        TSimpleServer.Args tArgs = new TSimpleServer.Args(serverTransport);
        tArgs.processor(processor);
        tArgs.protocolFactory(protocolFactory);
        // 简单的单线程服务模型 一般用于测试
        TServer tServer = new TSimpleServer(tArgs);
        System.out.println("运行 简单 服务");
        tServer.serve();
    }
}
