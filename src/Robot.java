import javax.swing.*;
import java.awt.*;

class Robot extends JLabel implements Runnable {

    protected String nom;
    protected int x;
    protected int y;
    protected int energie;
    protected int capacite;
    protected int i=1;
    protected ImageIcon imageIcon;
    protected String direction;

    public int getEnergie() {
        return energie;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }



    Robot(String nom){
        this.nom=nom;
        x=y=0;
        direction="Est";
    }

    public Robot(String nom, int x, int y, String direction, ImageIcon imageIcon)
    {
        this(nom);
        this.x = x;
        this.y = y;
        if (direction.equals("Nord") || direction.equals("Sud")
                || direction.equals("Ouest"))
            this.direction = direction;  // garder "Est" si direction invalide

        this.imageIcon=resizeimg(imageIcon);
        this.setIcon(this.imageIcon);



    }
    /**
     * avance d'un pas
     */
    public void avance()
    {
        setEnergie(getEnergie()-1);
        if (getEnergie()<=10){
            this.setLocation(1299,421);
            setEnergie(getCapacite());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            while (i==1){
                this.setLocation(this.x,this.y);
                i++;
            }

            int fX0 = 0, // left x border
                    fX1 = 1440, // right x border
                    fY0 = 0, // top y border
                    fY1 = 820; // bottom y border
            int rX0, rX1, rY0, rY1; // keep these values updated width the rectangles position:
            rX0 = this.getLocation().x;
            rX1 = this.getLocation().x+120;
            rY0 = this.getLocation().y;
            rY1 = this.getLocation().y+120;
// Then, to check if the rect is inside the frame:
            if (
                    rX0 >= fX0 &&
                            rX1 <  fX1 &&
                            rY0 >= fY0 &&
                            rY1 <  fY1
            ) { switch (direction) {
                case "Nord":
                    this.setLocation(this.getLocation().x,this.getLocation().y-1);
                    break;
                case "Est":
                    this.setLocation(this.getLocation().x-1,this.getLocation().y);
                    break;
                case "Sud":
                    this.setLocation(this.getLocation().x,this.getLocation().y+1);
                    break;
                case "Ouest":
                    this.setLocation(this.getLocation().x+1,this.getLocation().y);
                    break;
            } }
            else {
            /*switch (direction) {
                case "Nord":
                    System.out.println("changed to Sud");
                    this.direction="Sud";
                    this.setLocation(this.getLocation().x,this.getLocation().y+1);
                    break;
                case "Est":
                    System.out.println("changed to Ouest");

                    this.direction="Ouest";
                    this.setLocation(this.getLocation().x+1,this.getLocation().y);
                    break;
                case "Sud":
                    System.out.println("changed to Nord");

                    this.direction="Nord";
                    this.setLocation(this.getLocation().x,this.getLocation().y-1);
                    break;
                case "Ouest":
                    System.out.println("changed to Est");

                    this.direction="Est";
                    this.setLocation(this.getLocation().x-1,this.getLocation().y);
                    break;
            }*/

                if(this.getLocation().x<=-1){
                    this.direction="Est";
                    this.setLocation(this.getLocation().x+1,this.getLocation().y);
                } else if (this.getLocation().x>=1320){
                    this.direction="Ouest";
                    this.setLocation(this.getLocation().x-1,this.getLocation().y);
                }
                if (this.getLocation().y<=-1){
                    this.direction="Sud";
                    this.setLocation(this.getLocation().x,this.getLocation().y+1);
                }else if (this.getLocation().y>=700){
                    this.direction="Nord";
                    this.setLocation(this.getLocation().x,this.getLocation().y-1);
                }

            }
        }





    }
    /**
     * tourne à droite de 90°
     */
    public void droite()
    {
        switch (direction) {
            case "Nord":
                //System.out.println("tourne NRD");
                direction = "Est";
                break;
            case "Est":
                //System.out.println("tourne EST");
                direction = "Sud";
                break;
            case "Sud":
                //System.out.println("tourne SD");
                direction = "Ouest";
                break;
            case "Ouest":
                //System.out.println("tourne Ost");
                direction = "Nord";
                break;
        }
    }

    public static ImageIcon resizeimg(ImageIcon imageIcon){
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }

    @Override
    public void run() {

    }
}
