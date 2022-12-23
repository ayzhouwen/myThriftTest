//代码生成命令:thrift --gen java xxx.thrift
//.\thrift-0.17.0.exe --gen java D:\zw\mycode\myThriftTest\myThriftTest\src\main\resources\idl\student.thrift
//把生成后的文件TStudent.java和IStudentRPCService.java拷贝到项目中
struct TStudent{
//姓名
1:required string name
//年龄
2:optional i32 age
//地址
3:optional string addr
//自增id
4:required i64 id
}

//学生服务
service IStudentRPCService{
list<TStudent> getStudentList();
TStudent getStudentInfo(1:i64 id);
}


