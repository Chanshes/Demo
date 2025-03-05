# 使用Python开发安卓APP

虽然Python不是开发安卓APP的主流语言，但确实可以使用Python来开发安卓应用。主要的方法是使用Kivy框架，这是一个开源的Python库，专门用于跨平台应用开发。

## Kivy框架

Kivy是一套用于快速应用开发的开源框架，支持多点触控，能够让开发者快速完成简洁的交互原型设计，并支持代码重用和部署。Kivy不仅支持安卓，还支持iOS，因此只需编写一次代码，就可以生成多个平台的应用。

## 安装Kivy

在Windows平台上安装Kivy的步骤如下：
更新pip、wheel和setuptools： python -m pip install --upgrade pip wheel setuptools
安装所需的依赖：

    python -m pip install docutils pygments pypiwin32 kivy.deps.sdl2 kivy.deps.glew kivy.deps.gstreamer

安装Kivy：

    python -m pip install kivy

## 编写Hello World应用

以下是一个简单的Hello World应用示例：

    from kivy.app import App
    from kivy.uix.button import Button

    class TestApp(App):
        def build(self):
            return Button(text='Hello, Kivy')


    TestApp().run()

运行上述代码后，会弹出一个窗口，显示一个按钮，点击按钮会改变颜色

## 编译成APK文件

要将Python代码编译成安卓APK文件，需要使用Buildozer，这是一个自动化工具，可以将Python应用打包成安卓和iOS应用。

### 安装Buildozer

在CentOS系统上安装Buildozer的步骤如下：  
安装依赖：

    yum -y install vim make wget tar unzip zip bzip2 patch autoconf automake libtool lld zlib-devel bzip2-devel openssl-devel ncurses-devel sqlite-devel readline-devel tk-devel gcc gcc-c++ make libffi-devel java java-devel git

安装Python第三方包：

    pip3 install cython kivy buildozer

## 编译APK

初始化Buildozer：

    buildozer init

修改生成的buildozer.spec文件，设置应用的名称、包名和版本等信息。  
编译APK文件： buildozer -v android debug  
编译成功后，会在当前目录下生成一个bin文件夹，里面包含生成的APK文件。  
