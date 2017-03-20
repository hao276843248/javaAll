import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

  class Block implements Runnable// 方块类
  {
    static final int type = 7, state = 4;

    static final int[][] patten = { // 16进制代表每种方块
     { 0x0f00, 0x4444, 0x0f00, 0x4444 },// 长条
             { 0x6600, 0x6600, 0x6600, 0x6600 },// 正方块
             { 0x04e0, 0x0464, 0x00e4, 0x04c4 },// 三角
             { 0x08e0, 0x0644, 0x00e2, 0x044c },// 弯折一下，1、3，1左
            { 0x02e0, 0x0446, 0x00e8, 0x0c44 },// 弯折一下，1、3，1右
             { 0x0462, 0x006c, 0x0462, 0x006c },// 弯折两下，1、2、1，1左上；1右下
             { 0x0264, 0x00c6, 0x0264, 0x00c6 } // 弯折两下，1、2、1，1右上；1左下
     };
 
     private int blockType = -1; // 方块类型，7种，大小范围0-6
 
     private int blockState;// 方块状态，4种，大小范围0-3
 
     private int row, col; // 方块所在的行数，列数
 
     private int oldRow, oldCol; // 记录方块变化前所在的行数，列数
 
     private int oldType = -1, oldState; // 记录方块变化前的类型和状态
 
     private int isfall = 1; // 标记若画，画成什么颜色的，
 
     // 1表示可以下落，画为红色；0表示不可下落，画为蓝色
 
     private boolean end = false;// 结束标记，为true时表示结束
 
     LeftShowCanvas lsc;
 
     public Block(LeftShowCanvas lsc)
     {
        this.lsc = lsc;
         row = 0;
         col = 3;
         oldRow = row;
         oldCol = col;
     }
 
     public void reInit() // 一个方块无法下落后，重新初始化
     {
         blockType = -1;
         isfall = 1;
     }
 
     public void reInitRowCol() // 初始化方块起始点
     {
         row = 0;
         col = 3;
     }
 
 9    public void run() // 下落线程
 0    {
 1        lsc.requestFocusInWindow(); // 获得焦点
 2        while (!end)
 3        {
 4            int blocktype = (int) (Math.random() * 100) % 7;
 65            drawBlock(blocktype);
 6            do
 7            {
 8                try
 9                {
 0                    Thread.sleep(500); // 控制下落速度
 1                } catch (InterruptedException e)
 2                {
 3
 4                }
 5            } while (fallMove()); // 下落
 6            for (int j = 0; j < lsc.maxcols; j++)
 7                // 判断是否结束
 8                if (lsc.unitState[3][j] == 2)
 9                    end = true;
 0        }
 81    }
 2
 3    public synchronized void drawBlock(int blockType) // 画方块
 4    {
 5        if (this.blockType != blockType)
 6            blockState = (int) (Math.random() * 100) % 4; // 状态
 7        this.blockType = blockType; // 样式
 8        if (!isMove(3)) // 判断是否能画
9       {
9            this.blockType = oldType;
9            this.blockState = oldState;
9            return;
 3        }
9        int comIndex = 0x8000;
9        if (this.oldType != -1)
9        {
97            for (int i = oldRow; i < oldRow + 4; i++)
9                for (int j = oldCol; j < oldCol + 4; j++)
9                {
0                    if ((patten[oldType][oldState] & comIndex) != 0
0                            && lsc.unitState[i][j] == 1)
0                        //lsc.drawUnit(i, j, 0); // 先还原
3                        lsc.unitState[i][j]=0;//将状态记录改变，用于画下张图
4                    comIndex = comIndex >> 1;
05                }
6        }
7        comIndex = 0x8000;
8        for (int i = row; i < row + 4; i++)
09            for (int j = col; j < col + 4; j++)
0            {
1                if ((patten[blockType][blockState] & comIndex) != 0)
2                {
3                    if (isfall == 1)
4                        //lsc.drawUnit(i, j, 1); // 再画，画为RED
5                        lsc.unitState[i][j]=1; //将状态记录改变
6                    else if (isfall == 0)
7                    {
8                        //lsc.drawUnit(i, j, 2); // 无法下落，画为BLUE
9                        lsc.unitState[i][j]=2;//将状态记录改变，用于画下张图
0                        lsc.deleteFullLine(i); // 判断此行是否可以消
1                    }
2                }
3                comIndex = comIndex >> 1;
24            }
25        
6        Image image; //创建缓冲图片,利用双缓冲消除闪烁，画的下个状态图
7        image=lsc.createImage(lsc.getWidth(),lsc.getHeight());
8        Graphics g=image.getGraphics();
9        lsc.paint(g);
0        g.drawImage(image, 0, 0, lsc);
1            
2        if (isfall == 0) // 无法下落，先判断是否能消行，再重新初始化
3        {
4            // lsc.deleteFullLine(row,col);
35            reInit();
6            reInitRowCol();
7        }
8        oldRow = row;
39        oldCol = col;
0        oldType = blockType;
1        oldState = blockState;
2    }
3
4    public void leftTurn() // 旋转，左转
45    {
6        if (this.blockType != -1)
7        {
8            blockState = (blockState + 1) % 4;
9            if (isMove(3))
0                drawBlock(blockType);
1            else
2                blockState = (blockState + 3) % 4;
3        }
54    }
5
6    public void leftMove() // 左移
7    {
8        if (this.blockType != -1 && isMove(0))
9        {
0            col -= 1;
1            drawBlock(blockType);
2        }
3    }
4
5    public void rightMove() // 右移
6    {
7        if (this.blockType != -1 && isMove(1))
8        {
9            col += 1;
0            drawBlock(blockType);
171        }
2    }
3
4    public boolean fallMove() // 下移
   {
       if (this.blockType != -1)
       {
           if (isMove(2))
           {
               row += 1;
                drawBlock(blockType);
2                return true;
3            } else
4            {
5                isfall = 0;
6                drawBlock(blockType);
7                return false;
8            }
        }
0        return false;
1    }
92
   public synchronized boolean isMove(int tag) // 左 0 ，右 1 ，下 2 ,旋转 3
   {
       int comIndex = 0x8000;
      for (int i = row; i < row + 4; i++)
            for (int j = col; j < col + 4; j++)
           {
                if ((patten[blockType][blockState] & comIndex) != 0)
                {
                    if (tag == 0 && (j == 0 || lsc.unitState[i][j - 1] == 2))// 是否能左移
                       return false;
                    else if (tag == 1 && // 是否能右移
                           (j == lsc.maxcols - 1 || lsc.unitState[i][j + 1] == 2))
                        return false;
                    else if (tag == 2 && // 是否能下移
                            (i == lsc.maxrows - 1 || lsc.unitState[i + 1][j] == 2))
                        return false;
                    else if (tag == 3 && // 是否能旋转
                            (i > lsc.maxrows - 1 || j < 0
                                    || j > lsc.maxcols - 1 || lsc.unitState[i][j] == 2))
                        return false;
                }
                comIndex = comIndex >> 1;
            }
       return true;
    }
}
219
220class LeftShowCanvas extends Canvas
221{
222    int maxrows, maxcols; // 画布最大行数，列数
223
224    int unitSize; // 单元格的大小，小正方格
225
226    int[][] unitState; // 每个小方格的状态 0、1、2表示
227
228    RightPanel rp;
229
230    int score;
231
232    public LeftShowCanvas(RightPanel rp)
233    {
234        this.rp = rp;
235        score = Integer.valueOf(rp.jtf.getText());
236        maxrows = 20;
237        maxcols = 10;
238        unitSize = 20;
239        unitState = new int[maxrows][maxcols];
240        initCanvas();
241    }
242
243    public void initCanvas() // 初始化，画布方格
244    {
245        for (int i = 0; i < maxrows; i++)
246            for (int j = 0; j < maxcols; j++)
247                unitState[i][j] = 0;
248    }
249
250    public void paint(Graphics g)
251    {
252        for (int i = 0; i < maxrows; i++)
253        {
254            for (int j = 0; j < maxcols; j++)
255                drawUnit(i, j, unitState[i][j]); // 画方格
256            if (i == 3)
257            {
258                g.setColor(Color.RED);
259                g.drawLine(0, (i + 1) * (unitSize + 1) - 1, maxcols
260                        * (unitSize + 1) - 1, (i + 1) * (unitSize + 1) - 1);
261            }
262        }
263    }
264
265    public void drawUnit(int row, int col, int tag) // 画方格
266    {
267        unitState[row][col] = tag; // 记录状态
268        Graphics g = getGraphics();
269        switch (tag)
270        {
271        case 0: // 初始黑色
272            g.setColor(Color.BLACK);
273            break;
274        case 1: // 方格黑色
275            g.setColor(Color.RED);
276            break;
277        case 2:
278            g.setColor(Color.BLUE);
279            break;
280        }
281        g.fillRect(col * (unitSize + 1), row * (unitSize + 1), unitSize,
282                unitSize);
283    }
284
285    public void deleteFullLine(int row) // 判断此行是否可以消，同时可消就消行
286    {
287        for (int j = 0; j < maxcols; j++)
288            if (unitState[row][j] != 2)
289                return;
290
291        for (int i = row; i > 3; i--)
292            // 到此即为可消，将上面的移下消此行
293            for (int j = 0; j < maxcols; j++)
294                //drawUnit(i, j, unitState[i - 1][j]);
295            unitState[i][j]=unitState[i-1][j];//将状态记录改变，用于画下张图
296        score++;
297        rp.jtf.setText(String.valueOf(score));
298    }
299}
300
301class RightPanel extends JPanel
302{
303    JButton[] jbt = new JButton[7];
304
305    JButton[] jbt2 = new JButton[4];
306
307    JButton jbt3;
308
309    JTextField jtf;
310
311    JLabel jlb;
312
313    MyJPanel jp1, jp2;
314
315    public RightPanel()
316    {
317        jbt[0] = new JButton("长条");
318        jbt[1] = new JButton("方块");
319        jbt[2] = new JButton("三角");
320        jbt[3] = new JButton("左三");
321        jbt[4] = new JButton("右三");
322        jbt[5] = new JButton("左二");
323        jbt[6] = new JButton("右二");
324        jbt2[0] = new JButton("左移");
325        jbt2[1] = new JButton("右移");
326        jbt2[2] = new JButton("下移");
327        jbt2[3] = new JButton("翻转");
328
329        jbt3 = new JButton("开始");
330        jtf = new JTextField("0", 5);
331        jlb = new JLabel("得分", JLabel.CENTER);
332
333        jp1 = new MyJPanel(); // 左边的上面板
334        jp2 = new MyJPanel(); // 左边的下面板
335        jp1.setLayout(new GridLayout(4, 2, 20, 10)); // 网格布局
336        jp2.setLayout(new GridLayout(4, 2, 20, 10)); // 网格布局
337        this.setLayout(new BorderLayout()); // 边界布局
338        for (int i = 0; i < 7; i++)
339            jp1.add(jbt[i]);
340
341        jp1.add(jbt3);
342
343        for (int i = 0; i < 4; i++)
344            jp2.add(jbt2[i]);
345
346        jp2.add(jlb);
347        jp2.add(jtf);
348
349        this.add(jp1, "North");
350        this.add(jp2, "Center");
351    }
352}
353
354// 重写MyPanel类，使Panel的四周留空间
355class MyJPanel extends JPanel
356{
357    public Insets getInsets()
358    {
359        return new Insets(10, 30, 30, 30);
360    }
361}
362
363class MyActionListener implements ActionListener
364{
365    RightPanel rp;
366
367    Block bl;
368
369    LeftShowCanvas lsc;
370
371    public MyActionListener(RightPanel rp, Block bl, LeftShowCanvas lsc)
372    {
373        this.rp = rp;
374        this.bl = bl;
375        this.lsc = lsc;
376    }
377
378    public void actionPerformed(ActionEvent e)
379    {
380        if (e.getSource().equals(rp.jbt3))
381        {
382            // 这样子则按几次开始按钮就创建几个相同的线程，控制着相同的数据
383            Thread th = new Thread(bl);
384            th.start();
385        }
386        for (int i = 0; i < Block.type; i++)
387            if (e.getSource().equals(rp.jbt[i])) // 看是画哪个
388            {
389                bl.reInitRowCol();
390                bl.drawBlock(i);
391                lsc.requestFocusInWindow(); // 获得焦点
392                return;
393            }
394        if (e.getSource().equals(rp.jbt2[0]))
395            bl.leftMove();
396        else if (e.getSource().equals(rp.jbt2[1]))
397            bl.rightMove();
398        else if (e.getSource().equals(rp.jbt2[2]))
399            bl.fallMove();
400        else if (e.getSource().equals(rp.jbt2[3]))
401            bl.leftTurn();
402        lsc.requestFocusInWindow(); // 获得焦点
403    }
404}
405
406class MyKeyAdapter extends KeyAdapter
407{
408    Block bl;
409
410    public MyKeyAdapter(Block bl)
411    {
412        this.bl = bl;
413    }
414
415    public void keyPressed(KeyEvent e)
416    {
417        if (e.getKeyCode() == KeyEvent.VK_LEFT)
418            bl.leftMove();
419        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
420            bl.rightMove();
421        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
422            bl.fallMove();
423        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
424            bl.leftTurn();
425    }
426}
427
428public class FinalElsBlock extends JFrame
429{
430    Block bl;
431
432    LeftShowCanvas lsc;
433
434    RightPanel rp;
435
436    public FinalElsBlock()
437    {
438        super("ELSBlock Study");
439        setBounds(130, 130, 500, 450);
440        setLayout(new GridLayout(1, 2, 50, 30));
441        rp = new RightPanel();
442        lsc = new LeftShowCanvas(rp);
443        bl = new Block(lsc);
444        rp.setSize(80, 400);
445        for (int i = 0; i < 7; i++)
446            // 为每个按钮添加消息监听
447            rp.jbt[i].addActionListener(new MyActionListener(rp, bl, lsc));
448        rp.jbt3.addActionListener(new MyActionListener(rp, bl, lsc));
449        for (int i = 0; i < 4; i++)
450            rp.jbt2[i].addActionListener(new MyActionListener(rp, bl, lsc));
451        lsc.addKeyListener(new MyKeyAdapter(bl));
452        this.add(lsc);
453        this.add(rp);
454        this.addWindowListener(new WindowAdapter()
455        {
456            public void windowClosing(WindowEvent e)
457            {
458                dispose();
459                System.exit(0);
460            }
461        });
462        setVisible(true);
463    }
464
465    public static void main(String[] args)
466    {
467        new FinalElsBlock();
468    }
469}