# Login to the campus network of Chongqing Three Gorges University
# author: xingchen 21级物联网
# 备注： 该程序只作为校园网一键登录app，需要提前装好tkinter&win32模块 当然也可联系我直接拿app，我在这里将源码分享

import tkinter as tk
import tkinter.messagebox as msbox
import re
import os

from win10toast import ToastNotifier
import requests
import socket


class App:

    def __init__(self, width=400, height=260):
        self.username = ''
        self.password = ''
        self.mac = ''
        self.s = ''
        self.user = 'username:' + self.username + 'password:' + self.password + 'mac:' + self.mac + 'statu:200select:1'
        # statu:状态码 当值为200时启动程序直接登录 否则启动修改用户界面
        self.w = width
        self.h = height
        self.title = 'wifi'
        self.root = tk.Tk(className=self.title)
        self.v = tk.IntVar()
        self.v.set(self.s)
        self.read()

        def geten():
            self.username = euser.get()
            self.password = epass.get()
            self.mac = emac.get()
            num = self.v.get()
            if (num == 1):
                self.s = '1'
            else:
                self.s = '2'
            print(self.username)
            print(self.password)
            print(self.mac)
            self.loin()

        # Frame空间
        frameuser = tk.Frame(self.root)
        framein = tk.Frame(self.root)

        # 菜单
        menu = tk.Menu(self.root)
        self.root.config(menu=menu)
        helpmenu = tk.Menu(menu, tearoff=0)
        aboutmenu = tk.Menu(menu, tearoff=0)

        menu.add_cascade(label='帮助', menu=helpmenu)
        helpmenu.add_command(label='我的MAC在哪', command=self.macHelp)
        menu.add_cascade(label='关于', menu=aboutmenu)
        aboutmenu.add_command(label='作者的话:', command=self.authorWord)
        aboutmenu.add_command(label='关于此程序', command=self.aboutApp)

        # 定义控件内容
        lu = tk.Label(frameuser,
                      text='学号/工号: ',
                      padx=10,
                      pady=10,
                      font=('楷体', 15))
        euser = tk.Entry(frameuser)
        lp = tk.Label(frameuser,
                      text='密码: ',
                      padx=10,
                      pady=10,
                      font=('楷体', 15))
        epass = tk.Entry(frameuser)
        lm = tk.Label(frameuser,
                      text='MAC: ',
                      padx=10,
                      pady=10,
                      font=('楷体', 15))
        emac = tk.Entry(frameuser)

        group = tk.Label(framein, text='网络通道：', padx=10, pady=10)
        tb1 = tk.Radiobutton(framein,
                             text='WiFi',
                             variable=self.v,
                             value=1,
                             width=10,
                             height=3)
        tb2 = tk.Radiobutton(framein,
                             text='网线',
                             variable=self.v,
                             value=2,
                             width=10,
                             height=3)
        enter = tk.Button(framein,
                          text='保存',
                          relief=tk.RAISED,
                          width=4,
                          height=1,
                          font=('楷体', 12),
                          fg='Purple',
                          command=geten)
        if (self.s == '1'):
            tb1.select()
        else:
            tb2.select()

        euser.insert(0, self.username)
        epass.insert(0, self.password)
        emac.insert(0, self.mac)

        # 控件布局
        frameuser.pack()
        framein.pack()
        lu.grid(row=1, column=0)
        euser.grid(row=1, column=1)
        lp.grid(row=2, column=0)
        epass.grid(row=2, column=1)
        lm.grid(row=3, column=0)
        emac.grid(row=3, column=1)
        group.grid(row=1, column=0)
        tb1.grid(row=1, column=1)
        tb2.grid(row=1, column=2)
        enter.grid(row=3, column=1)

    # 窗口跳转
    def loin(self):
        self.save()
        msbox.showinfo(title='link', message='success')
        os._exit(0)

    # 窗口居中
    def center(self):

        ws = self.root.winfo_screenwidth()
        hs = self.root.winfo_screenheight()
        x = int((ws / 2) - (self.w / 2))
        y = int((hs / 2) - (self.h / 2))
        self.root.geometry('{}x{}+{}+{}'.format(self.w, self.h, x, y))

    # 等待用户事件
    def loop(self):
        # 禁止修改窗口大小
        self.root.resizable(False, False)
        # 窗口居中
        self.center()
        self.root.mainloop()

    # 文件写入
    def save(self):
        self.user = 'username:' + self.username + 'password:' + self.password + 'mac:' + self.mac + 'statu:200' + 'select:' + self.s
        with open(os.getcwd() + '\\document-link\\user-agent.txt', 'wb') as f:
            f.write(self.user.encode('utf-8'))
            f.close()

    # 文件读取
    def read(self):
        with open(os.getcwd() + '\\document-link\\user-agent.txt', 'r') as f:
            struser = f.read()
            print(struser)
            r = re.search(
                'username:(\\d*)password:(.*)mac:(.*)statu:(.*)select:(.*)',
                struser)
            self.username = r.group(1)
            print('username:' + self.username)
            self.password = r.group(2)
            print('password:' + self.password)
            self.mac = r.group(3)
            print('mac:' + self.mac)
            p = r.group(4)
            print(p)
            self.s = r.group(5)
            f.close()

    # 帮助
    def macHelp(self):
        msbox.showinfo(
            title='我的MAC在哪？',
            message='方法一:打开校园网登录网站，浏览器地址栏中有mac=00:00:ab:cd:ef:00\n方法二: 打开网络和Internet设置，点击属性，属性的最后一栏即物理地址(MAC)'
        )

    def authorWord(self):
        msbox.showinfo(
            title='作者的话',
            message='该程序只作为校园网一键登录app，我在Github将源码分享 ---Github:https://github.com/Chanshes/Demo/tree/main/myProject'
        )

    def aboutApp(self):
        msbox.showinfo(
            title='使用方法',
            message='初次进入时会生成user-agent文件账号密码会保存在这个文件夹中,注意不要删除\n在程序填写保存后再次打开程序即可进行自动登录,若将WiFi和网线选择错误会误报登录成功,需要进入user-agent文件手动将状态码修改为400,保存后打开程序弹出修改用户账号界面'
        )


def get_ip():
    hostname = socket.gethostname()
    ip = socket.gethostbyname(hostname)
    return ip


def link(username, password, mac, select):
    login_IP = 'http://172.22.0.13/webauth.do?wlanuserip=' + get_ip() + \
            '&wlanacname=NFV-VBRAS-0' + select + '&mac=' + mac + '&vlan=1056&rand=14bb62975092b4&url=http://edge.microsoft.com/generate_20'

    dat = 'loginType=&auth_type=0&isBindMac1=1&pageid=61&templatetype=1&listbindmac=1&recordmac=0&isRemind=0' \
        '&loginTimes=&groupId=&distoken=&echostr=&url=http://edge.microsoft.com/generate_20&isautoauth=&userId=' + \
        username + '&passwd=' + password
    headers = {
        'Accept':
        'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
        'Accept-Encoding':
        'gzip, deflate',
        'Accept-Language':
        'zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6',
        'Cache-Control':
        'max-age=0',
        'Connection':
        'keep-alive',
        'Content-Length':
        '234',
        'Content-Type':
        'application/x-www-form-urlencoded',
        'Host':
        '172.22.0.13',
        'Origin':
        'http://172.22.0.13',
        'Referer':
        'POST http://172.22.0.13/webauth.do?wlanuserip=' + get_ip() +
        '&wlanacname=NFV-VBRAS-0' + select + '&mac=' + mac +
        '&vlan=1056&rand=12b70fb2155820&url=http://edge.microsoft.com/generate_20',
        'Upgrade-Insecure-Requests':
        '1',
        'User-Agent':
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36 Edg/101.0.1210.47'
    }

    try:
        r = requests.post(login_IP, data=dat, headers=headers)
        r.encoding = r.apparent_encoding
        req = r.text
    finally:
        if "此IP已在线请下线后再认证" in req:
            ToastNotifier().show_toast(title="该设备已经登录",
                                       msg="校园网状态",
                                       duration=3,
                                       threaded=False)
            user = 'username:' + username + 'password:' + password + 'mac:' + mac + 'statu:200' + 'select:' + select
            with open(os.getcwd() + '\\document-link\\user-agent.txt',
                      'wb') as f:
                f.write(user.encode('utf-8'))
                f.close()
            os._exit(0)

        elif "认证成功" in req:
            ToastNotifier().show_toast(title="登录成功",
                                       msg="校园网状态",
                                       duration=3,
                                       threaded=False)
            user = 'username:' + username + 'password:' + password + 'mac:' + mac + 'statu:200' + 'select:' + select
            with open(os.getcwd() + '\\document-link\\user-agent.txt',
                      'wb') as f:
                f.write(user.encode('utf-8'))
                f.close()
            os._exit(0)

        else:
            ToastNotifier().show_toast(title="未连接到校园网,或出现其它问题",
                                       msg="校园网状态",
                                       duration=1,
                                       threaded=False)
            user = 'username:' + username + 'password:' + password + 'mac:' + mac + 'statu:400' + 'select:' + select
            with open(os.getcwd() + '\\document-link\\user-agent.txt',
                      'wb') as f:
                f.write(user.encode('utf-8'))
                f.close()
            os._exit(0)


if __name__ == '__main__':

    # 初始化
    b = os.getcwd() + '/document-link'
    if not os.path.exists(b):
        # 判断当前路径是否存在，没有则创建新文件夹
        os.makedirs(b)
        xo = b + '/user-agent.txt'
        # 在当前py文件所在路径下的document文件中创建txt
        file = open(xo, 'w')
        useragent = 'username:password:mac:statu:400select:1'
        file.write(useragent)  # 写入内容信息
        file.close()

        he = b + '/help.txt'
        file = open(he, 'w')
        strhelp = '初次进入时会生成user-agent文件账号密码会保存在这个文件夹中,注意不要删除\n在程序填写保存后再次打开程序即可进行自动登录,若将WiFi和网线选择错误会误报登录成功,需要进入user-agent文件手动将状态码修改为400,保存后打开程序弹出修改用户账号界面'
        file.write(strhelp)
        file.close()

    # 读取内容
    with open(os.getcwd() + '\\document-link\\user-agent.txt', 'r') as f:
        struser = f.read()
        # print(struser)
        r = re.search(
            'username:(\\d*)password:(.*)mac:(.*)statu:(.*)select:(.*)',
            struser)
        username = r.group(1)
        # print('username:'+self.username)
        password = r.group(2)
        # print('password:'+self.password)
        mac = r.group(3)
        # print('mac:'+self.mac)
        statu = r.group(4)
        select = r.group(5)
        f.close()

    if (statu == '200'):
        link(username, password, mac, select)
    else:
        app = App()
        app.loop()
