# reptile
    HTTP测试需求库:
        pip install requests
## Requests：
        作用：发送网络请求，获得响应数据
    Requests是一个Python代码编写的HTTP请求库，方便在代码中模拟浏览器发送HTTP请求

    1.实例引入
        import requests

        response = requests.get('https://www,baidu.com/')
        print(response) # 直接打印变量得到的是一个响应体对象
        print(type(response.text)) # 查看响应体内容 类型为str
        print(response.status_code) # 查看响应状态码
        
    2.各种请求方式：
        requests.get('url') # GET请求
        requests.post('url') # POST请求
    
    3.1基于get请求
        1.基本写法
            # 测试网站：http://httpbin.org/get
            url ='http://httpbin.org/get' # 目标站点
            r = requests.get(url)
            print(r.status_code)
            print(r.text)
            print(type(r.text))

        2.带参数的get请求
            # 测试网站：http://httpbin.org/get
            # 第一种写法
            url = 'http://httpbin.org/get?'
            r = requests.get(url)
            print(r.text) 
            # 第二种写法 推荐
            data = {
                'name':"lisi",
                'age':12
            }
            url = 'http://httpbin.org/get'
            r = requests.get(url,params=data) # params参数的作用时携带get请求的相关参数 构建在字典中
            print(r.text) 
    3.2基于post请求
        post不会被浏览器标记，不能被浏览器直接打开
        # http://httpbin.org/post
        data = {
            'name':"lisi",
        }
        url = 'http://httpbin.org/post'
        r = requests.post(url,data =d) # data参数作用：携带post请求参数用的
        print(r.text)
    
    4.json解析（对于json）
        import requests
        import json
        url = 'http:httpbin.org/get'
        r = requests.get(url)
        print(r.status_code) # 查看响应状态码
        a = r.text
        print(a)
        print(type(a)) # 将长得像字典的字符串数据 -- json数据

        data_dict = json.loads(a)
        print(data_dict['url'])
        print(data_dict['Host'])
        
        data_json = r.json() # .json方法作用时获取Json形式的源码 位于requests包数据类型为字典(dict)
        print(data_json)
        print(type(data_json))

    5. .content获取二进制数据
        # 目标站点 百度logo https://www.baidu.com/img/baidu_jgylogo3.gif
        url = 'https://www.baidu.com/img/baidu_jgylogo3.gif'
        r = requests.get(url)
        print(r.content)
        print(type(r.content))

        with open('bdfp.gif','wb')as f:   # 保存至本地磁盘
            f.write(data)
        print(data)

    6.初步伪装小爬虫--添加headers
        浏览器用户身份的标识，缺少的话服务器会认为你不是一个正常的浏览器用户，而是一个爬虫程序
        user-agent:Mozilla/5.0
        伪装：
        h = {
            'user-agent':'Mozilla/5.0(windows NT 10.0; Win64; x64)'
        }
            url = 'https://www.zhihu.com/explore'
            r = requests.get(url,headers =h) # headers参数： 携带身份信息
            print(r.status_code)

## Response响应
    1.response属性
        headers= {
            'User-agent':'Mozilla/5.0(windows NT 10.0; Win64; x64)'
        }
        r = requests.get(url,headers = headers)
        print(r.statu_code)

    2.状态码分析
        200:
        300:
        400:
        404:
    
## 高级操作
    会话维持
        http/https协议 是一种无状态