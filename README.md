# ChenLibs

1. 封装日志工具类使用"," 拼接字符串

> 打印样式
```
04-21 21:40:54.280 31944-31966/com.chen.chenlibs I/Version:1.0|ChenLog|MainActivity$1.onSuccess(L:21)>
```


2. 封装okhttp 请求 
1. get请求
mType 为请求返回json 字符串对应的bean,默认可以传 null 不进行解析

```
        ChenOkHttp.getInstance()
                .doGet(videoUrl)
                .onResult(mType, new ChenResultCallBack<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {

                        ChenLog.i("result:>>>", bean);
                    }
                });
```


2. get请求,带字符串拼接url

         /**
         * get 参数键值对,内部可根据键值对拼接成 xxx?key=val&key2=val2.....
         */
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("chen", "chenxzong");
        bodyMap.put("age", 13);
        bodyMap.put("addr", "青岛市李沧区");
        bodyMap.put("girl", false);

        /**
         * header参数
         */
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("token", "token");

        /**
         * 需要拼接 url参数
         */
        ChenOkHttp.getInstance()
                .doGet(url, bodyMap)
                .addHeaders(headersMap)
                .onResult(UserInfoJsonBean.class, new ChenResultCallBack<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {
                        System.out.println(bean);
                    }
                });



3. post请求


        /**
         * post Body 参数
         */
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("chen", "chenxzong");
        bodyMap.put("age", 13);
        bodyMap.put("addr", "青岛市李沧区");
        bodyMap.put("girl", false);
        String jsonBody = "{\n" +
                "        \"name\": \"chenxzong\",\n" +
                "        \"age\": 30,\n" +
                "        \"info\": \"山东省青岛市李沧区\"\n" +
                "    }";

        /**
         * headers 参数
         */
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("token", "token");

        ChenOkHttp.getInstance()
                .doPost(url)
                .addHeaders(headersMap)
                .addMapBody(bodyMap)
                .addJsonBody(jsonBody)
                .onResult(null, new ChenResultCallBack<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {

                    }
                });



3. okhttp请求增加url检查



4. 默认包含如下第三方包
    api files('libs/gson-2.8.5.jar')
    api files('libs/okhttp-3.8.1.jar')
    api files('libs/okio-1.13.0.jar')

#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
