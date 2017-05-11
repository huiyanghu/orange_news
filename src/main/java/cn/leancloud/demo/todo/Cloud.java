package cn.leancloud.demo.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avos.avoscloud.AVCloud;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;

import cn.leancloud.EngineFunction;
import cn.leancloud.EngineFunctionParam;

public class Cloud {

  @EngineFunction("hello")
  public static String hello() {
    return "Hello world!";
  }

  @EngineFunction("listTodo")
  public static List<Todo> getTodos(@EngineFunctionParam("limit") int limit) throws AVException {
    AVQuery<Todo> query = AVObject.getQuery(Todo.class);
    query.orderByDescending("createdAt");
    query.limit(limit);
    try {
      return query.find();
    } catch (AVException e) {
      if (e.getCode() == 101) {
        // 该错误的信息为：{ code: 101, message: 'Class or object doesn\'t exists.' }，说明 Todo 数据表还未创建，所以返回空的
        // Todo 列表。
        // 具体的错误代码详见：https://leancloud.cn/docs/error_code.html
        return new ArrayList<>();
      }
      throw e;
    }
  }

    @EngineFunction("listTest")
    public static List<Test> getTests(@EngineFunctionParam("limit") int limit) throws AVException {
        AVQuery<Test> query = AVObject.getQuery(Test.class);
        query.orderByDescending("createdAt");
        query.limit(limit);
        try {
            List<Test> testList = query.find();
            System.out.print(testList.size());
            return testList;
        } catch (AVException e) {
            System.out.print("exception" + e);
            if (e.getCode() == 101) {
                // 该错误的信息为：{ code: 101, message: 'Class or object doesn\'t exists.' }，说明 Todo 数据表还未创建，所以返回空的
                // Todo 列表。
                // 具体的错误代码详见：https://leancloud.cn/docs/error_code.html
                return new ArrayList<>();
            }
            throw e;
        }
    }

    @EngineFunction("getTestFunction")
    public static List<String> get_test_function() throws AVException {

        List<String> todos = new ArrayList<String>();
        todos.add("11111111");
        todos.add("22222");
        todos.add("3333333");
        todos.add("444444");
        todos.add("55555555");
        return todos;
    }
}



