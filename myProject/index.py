import win32gui as gui
import win32con as con
import time
# QQ轰炸器
handle = gui.FindWindow(0, '***')

for i in range(100):
    gui.SendMessage(handle, con.WM_PASTE)
    gui.SendMessage(handle, con.WM_KEYDOWN, con.VK_RETURN)
    time.sleep(1)