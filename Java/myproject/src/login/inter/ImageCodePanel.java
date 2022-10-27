package login.inter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageCodePanel extends JPanel {
    private static final long serialVersionUID = -3124698225447711692L;
    public static final int WIDTH = 100;// ���
    public static final int HEIGHT = 30;// �߶�
    private String num = "";// ��֤��
    Random random = new Random();// ʵ����Random
    
    public ImageCodePanel() {
        this.setVisible(true);// ��ʾ���
        setLayout(null);// �ղ���
        }
    
    public void paint(Graphics g) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);// ʵ����BufferedImage
        Graphics gs = image.getGraphics(); // ��ȡGraphics��Ķ���
        if (!num.isEmpty()) {
            num = "";// �����֤��
        }
        Font font = new Font("΢���ź�", Font.BOLD, 20); // ͨ��Font��������
        gs.setFont(font);// ��������
        gs.fillRect(0, 0, WIDTH, HEIGHT);// ���һ������
        //
        
        Image img = null;
        try {
            img = ImageIO.read(new File("images/image.jpg"));  // ����ͼ�����
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.getGraphics().drawImage(img, 0, 0, WIDTH, HEIGHT, null);// �ڻ���ͼ������ϻ���ͼ��
        
        
        // ����������֤����
        for (int i = 0; i < 4; i++) {
            char ctmp = (char) (random.nextInt(26) + 65); // ����A~Z����ĸ
            num += ctmp;//�����ɵ���ĸ������num�Ա�ʹ��
            Color color = new Color(20 + random.nextInt(120), 20 + random
                    .nextInt(120), 20 + random.nextInt(120));// ���������ɫ
            gs.setColor(color); 
            Graphics2D gs2d = (Graphics2D) gs;// ��������תָ���Ƕ�
            AffineTransform trans = new AffineTransform();// ʵ����AffineTransform
            /*https://blog.csdn.net/yuyue618/article/details/83260689?ops_reque
            st_misc=%257B%2522request%255Fid%2522%253A%2522165560076116
            781435477497%2522%252C%2522scm%2522%253A%252220140713.13
            0102334..%2522%257D&request_id=165560076116781435477497&biz
            _id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~s
            obaiduend~default-2-83260689-null-null.142^v17^control,157^v15^
            new_3&utm_term=AffineTransform&spm=1018.2226.3001.4187*/
            trans.rotate(random.nextInt(45) * 3.14 / 180, 22 * i + 8, 7);
            float scaleSize = random.nextFloat() + 0.8f;// ��������
            if (scaleSize > 1f)
                scaleSize = 1f;// ���scaleSize����1,�����1
            trans.scale(scaleSize, scaleSize); // ��������
            gs2d.setTransform(trans);// ����AffineTransform����
            gs.drawString(String.valueOf(ctmp), WIDTH / 6 * i + 28, HEIGHT / 2);// ������֤��
        }
        g.drawImage(image, 0, 0, null);// ������л�����֤��
    }
    
    // ������֤��ķ���
    public void draw() {
        repaint();// ����paint()����
    }
    
    public String getNum() {
        return num;// ������֤��
    }
}
