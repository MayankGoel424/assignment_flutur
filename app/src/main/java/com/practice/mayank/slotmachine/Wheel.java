package com.practice.mayank.slotmachine;

public class Wheel extends Thread {
    interface Wheellistner{
        void newImage(int img);
    }
    private static int imgs[] = {R.drawable.slot1,R.drawable.slot3,R.drawable.slot4,R.drawable.slot5,R.drawable.slot6};
    public int currentIndex;
    private long frameduration;
    private long startIn;
    private boolean isstarted;
    private Wheellistner wheellistner;
    public Wheel(Wheellistner wheellistner, long frameduration, long startIn){
        this.wheellistner=wheellistner;
        this.frameduration=frameduration;
        this.startIn=startIn;
        currentIndex=0;
        isstarted=true;
    }

    public void nextimage()
    {
        currentIndex++;
        if(currentIndex == imgs.length){
            currentIndex=0;
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(startIn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (isstarted){
            try {
                Thread.sleep(frameduration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextimage();
            if(wheellistner !=null){
                wheellistner.newImage(imgs[currentIndex]);
            }
        }
    }
    public void stopwheel()
    {
        isstarted=false;
    }
}
