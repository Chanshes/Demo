solartermno=input("你要查询第几个节气？")
solartermlist=["立春","雨水","惊蛰","春分","清明","谷雨",
               "立夏","小满","芒种","夏至","小暑","大署",
               "立秋","处暑","白露","秋分","寒露","霜降",
               "立冬","小雪","大雪","冬至","小寒","大寒"]
solarterm=solartermlist[int(solartermno)-1]
seasonlist=["春","夏","秋","冬"]
seasonno=int(int(solartermno)/6)
season=seasonlist[seasonno]
spring=(solartermlist[0:6])
summer=(solartermlist[6:12])
autumn=(solartermlist[12:18])
winter=(solartermlist[18:24])
print(seasonno)
other = None
if seasonno==0:
 other=spring
if seasonno==1:
 other=summer
if seasonno==2:
 other=autumn
if seasonno==3:
 other=winter
print("你要查询的节气是{}".format(solarterm))
print("这是{}节气".format(season))
print("这个季节还有以下节气\n")
for i in other:
    print(other[i])
    i = i+1