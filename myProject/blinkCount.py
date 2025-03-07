import cv2
import winsound
# 加载分类器
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')
eye_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_eye.xml')

# 初始化摄像头
cap = cv2.VideoCapture(0)
blink_counter = 0
eye_status = {"left": False, "right": False}  # 眼睛状态跟踪
cooldown = 0  # 防抖计数器

while True:
    ret, frame = cap.read()
    if not ret:
        break
  
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, 1.3, 5)

    current_eyes = []
    for (x, y, w, h) in faces:
        roi_gray = gray[y:y+h, x:x+w]
        eyes = eye_cascade.detectMultiScale(roi_gray, scaleFactor=1.05,minNeighbors=7,minSize=(25,25))
      
        # 眼睛定位与状态检测
        for (ex, ey, ew, eh) in eyes:
            # 判断左/右眼（根据水平位置）
            eye_center = x + ex + ew//2
            if eye_center < x + w//2:
                eye_type = "left"
            else:
                eye_type = "right"
          
            # 记录当前检测到的眼睛
            current_eyes.append(eye_type)
          
            # 绘制定位圆点
            cv2.circle(frame, 
                      (x + ex + ew//2, y + ey + eh//2),
                      5, (0,0,255), -1)

    # 眨眼计数逻辑（状态变化检测）
    new_status = {
        "left": "left" in current_eyes,
        "right": "right" in current_eyes
    }

    # 当任意一只眼睛从可见变为不可见时计数
    if cooldown <= 0:
        if (eye_status["left"] and not new_status["left"]) or \
           (eye_status["right"] and not new_status["right"]):
            blink_counter += 1
            winsound.Beep(1000, 100)  # 1000Hz频率，持续100ms
            cooldown = 15  # 设置15帧冷却时间（约0.5秒）
  
    eye_status = new_status
    if cooldown > 0:
        cooldown -= 1

    # 显示统计结果
    cv2.putText(frame, f"Blinks: {blink_counter}", (10,30),
                cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0,255,0), 2)
  
    cv2.imshow('Blink Detection', frame)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()