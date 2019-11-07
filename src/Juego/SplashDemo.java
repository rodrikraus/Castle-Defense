package Juego;

import java.awt.*;
import javax.swing.*;
 
public class SplashDemo extends JWindow {
     
    private int duration;
     
    public SplashDemo(int d) {
        duration = d;
    }
     
    // Muestro la imagen en el centro de la pantalla
    // por la cantidad de tiempo especificada en el constructor
    public void showSplash() {
         
        JPanel content = (JPanel)getContentPane();
        //content.setBackground(Color.white);
         
        // Establezco los bounds de la ventana, poniendola en el medio de la pantalla
        int width = 509;
        int height = 305 + 30;  
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
         
        // Construyo el splash screen
        ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource("img/mapa/splash.jpg"));
        JLabel label = new JLabel(imagen);
        
        // La etiqueta "<br>" hace un salto de linea en el texto de un JLabel
        JLabel copyrt = new JLabel
        		("<html>Copyright 2019 <br> Juan Ignacio Fabrega  -"
        				+ "  Rodrigo Kraus  -  Matias David Schwerdt </html>", JLabel.CENTER);
        
        
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(156, 20, 20,  255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));
         
        // Lo muestro
        setVisible(true);
         
        // Se muestra durante la duracion del constructor, (tambien sirve para que el juego cargue mientras se muestra)
        try { Thread.sleep(duration); } catch (Exception e) {}
         
        setVisible(false);
         
    }
/*
    public static void main(String[] args) {
         
        // Asi se crearia
    	SplashDemo splash = new SplashDemo(10000);
 
        // Lo muestro
        splash.showSplash();
        System.exit(0); // Esto en el juego no es necesario porque lo puedo cerrar con la x
         
    }
    */
}