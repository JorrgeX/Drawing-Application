/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author acv
 */
public class DrawingApplicationFrame extends JFrame
{

    // Create the panels for the top of the application. One panel for each
    // line and one to contain both of those panels.
    private final JPanel firstPanel;
    private final JPanel secondPanel;
    private final JPanel topPanel;
    // create the widgets for the firstLine Panel.
    private final JButton undo;
    private final JButton clear;
    private final JLabel shapeLabel;
    private final JComboBox shape;
    private static String shapeChoice;
    private final JCheckBox filled;
    private final JLabel filledLabel;
    //create the widgets for the secondLine Panel.
    private final JCheckBox gradient;
    private final JLabel gradientLabel;
    private final JButton color1;
    private final JButton color2;
    private final JColorChooser colorChoose;
    private final JLabel strokeWidthLabel;
    private final JTextField strokeWidth;
    private static double lineWidth;
    private final JLabel dashLengthLabel;
    private final JTextField dashLength;
    private final JCheckBox dash;
    private final JLabel dashLabel;
    // Variables for drawPanel.
    private final JPanel drawPanel;
    private static ArrayList<String> stroke;
    private Color color = Color.WHITE;
    private Color color11 = Color.WHITE;
    private Color color22 = Color.WHITE;
    Point a, b;
    // add status label
    private final JLabel status;
    
    // Constructor for DrawingApplicationFrame
    public DrawingApplicationFrame()
    {
        // add widgets to panels
        // firstLine widgets
        firstPanel = new JPanel();
        undo = new JButton("Undo");
        clear = new JButton("Clear");
        shapeLabel = new JLabel("Shape:");
        String[] shapeStrings = {"line","oval","rectangle"};
        shape = new JComboBox(shapeStrings);
        filled = new JCheckBox();
        filledLabel = new JLabel("Filled");
        
        
        firstPanel.add(undo);
        firstPanel.add(clear);
        firstPanel.add(shapeLabel);
        firstPanel.add(shape);
        firstPanel.add(filled);
        firstPanel.add(filledLabel);

        // secondLine widgets
        secondPanel = new JPanel();
        gradient = new JCheckBox();
        gradientLabel = new JLabel("Use Gradient");
        color1 = new JButton("1st Color");
        color2 = new JButton("2nd Color");
        colorChoose = new JColorChooser();
        strokeWidthLabel = new JLabel("Line Width:");
        strokeWidth = new JTextField(1);
        dashLengthLabel = new JLabel("Dash Length:");
        dashLength = new JTextField(1);
        dash = new JCheckBox();
        dashLabel = new JLabel("Dashed");
        
        secondPanel.add(gradient);
        secondPanel.add(gradientLabel);
        secondPanel.add(color1);
        secondPanel.add(color2);
        secondPanel.add(strokeWidthLabel);
        secondPanel.add(strokeWidth);
        secondPanel.add(dashLengthLabel);
        secondPanel.add(dashLength);
        secondPanel.add(dash);
        secondPanel.add(dashLabel);
        
        // add top panel of two panels
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,0));
        topPanel.add(firstPanel);
        topPanel.add(secondPanel);
        
        // add topPanel to North, drawPanel to Center, and statusLabel to South
        drawPanel = new DrawPanel();
        drawPanel.setBackground(Color.WHITE);
        status = new JLabel();
        setLayout(new GridLayout(3,0));
        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
        
        //add listeners and event handlers
        UndoHandler undohandler = new UndoHandler();
        Undo.addActionListener(undohandler);
        ClearHandler clearhandler = new ClearHandler();
        Clear.addActionListerner(clearhandler);
        ShapeSelectionHandler shapeselectionhandler = new ShapeSelectionHandler(ShapeSelection);
        ShapeSelection.addActionListerner(shapeselectionhandler);
        FillHandler fillhandler = new FillHandler(filled);
        filled.addActionListener(fillhandler);
        FirstHandler firsthandler = new FirstHandler(gradient);
        color1.addActionListener(firsthandler);
        SecondHandler secondhandler = new SecondHandler(gradient);
        color2.addACtionListener(secondhandler);
        WidthHandler widthhandler = new WidthHandler(strokeWidth);
        strokeWidth.addActionListener(widthhandler);
        DashHandler dashhandler = new DashHandler(dashLength);
        dashLength.addActionListener(dashhandler);
        DashCheckBoxHandler dashcheckboxhandler = new DashCheckBoxHandler(dash);
        dash.addActionListener(dashcheckboxhandler);
//        MouseHandler handler = new MouseHandler();
//        drawPanel.addMouseMotionListener(handler);
        

//        //undo
//        undo.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                if (stroke.size()!=0){
//                    stroke.remove(stroke.size()-1);
//                    repaint();
//                }
//                
//            }
//        });
        
        //clear
//        clear.addActionListener(new ActionListener(){
//           @Override
//           public void actionPerformed(ActionEvent e){
//               stroke = new ArrayList<>();
//               repaint();
//           }
//        });
        
        //filled
        if (filled.isSelected()){
            if (shapeChoice == "rectangle"){
                ///
            }
        }
        

        //shape
//        shape.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                JComboBox choice = (JComboBox) e.getSource();
//                shapeChoice = (String) choice.getSelectedItem();
//            }
//        });
        
        //color choice
//        color1.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                color11 = JColorChooser.showDialog(DrawingApplicationFrame.this,"Choose a color",color11);
//                if (color11 == null)
//                    color11 = Color.WHITE;
//            }
//        });
//        color2.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                color22 = JColorChooser.showDialog(DrawingApplicationFrame.this,"Choose a color",color22);
//                if (color22 == null)
//                    color22 = Color.WHITE;
//            }
//        });
        
        //gradient checkbox
        if (gradient.isSelected()){
            Paint paint = new GradientPaint(0,0,color11, 50, 50, color22, true);
        }
        else{
            Paint paint = color11;
        }
        
        //linewidth
        strokeWidth.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double width = (double) e.getSource();
                lineWidth = (double) width.get;
            }
        });
        
        
        //dash checkbox
//        if (dash.isSelected()){
//            stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,10,dashLength,0);
//        }
//        else{
//            stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
//        }
    }

    // Create event handlers, if needed
    
    //undo
    private class UndoHandler implements ActionListener{
//        undo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (stroke.size()!=0){
                    stroke.remove(stroke.size()-1);
                    repaint();
                }
                
            }
        };
    
    //clear
    private class ClearHandler implements ActionListener{
//                clear.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               stroke = new ArrayList<>();
               repaint();
           }
        };
    
    //shape
    private class ShapeSelectionHandler implements ActionListener{
//                shape.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JComboBox choice = (JComboBox) e.getSource();
                shapeChoice = (String) choice.getSelectedItem();
             
        };
    }
    
    //color
    private class FirstHandler implements ActionListener{
//        color1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                color11 = JColorChooser.showDialog(DrawingApplicationFrame.this,"Choose a color",color11);
                if (color11 == null)
                    color11 = Color.WHITE;
            }
        };
    
    
    private class MouseHandler implements MouseMotionListener{
        @Override 
        public void mouseDragged(MouseEvent e){
            status.setText(String.format("[%d,%d]", e.getX(), e.getY()));
        }
        public void mouseMoved(MouseEvent e){
            status.setText(String.format("[%d,%d]", e.getX(), e.getY()));
        }
    }
    
    private class WidthHandler implements ActionListener{
        private JTextField text;
        private int num;
        
        WidthHandler(JTextField Text){
            text = Text;
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            num = Integer.parseInt(text.getText());
            drawPanel.setStrokeWidth(num);
        }
    }
    
    private class DashHandler implements ActionListener{
        private JTextField text;
        private int num;
        DashHandler (JTextField Text){
            text = Text;
        }
        
        @Override 
        public void actionPerformed(ActionEvent e){
            num = Integer.parseInt(text.getText());
            drawPanel.setDashLength(num);
        }
    }
    

    // Create a private inner class for the DrawPanel.
    private class DrawPanel extends JPanel
    {
        
        public DrawPanel()
        {
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //loop through and draw each shape in the shapes arraylist
            int counter;
            for (counter = 0; counter< stroke.size(); counter ++){
                stroke.get(counter).split("");
            }
        }


        private class MouseHandler extends MouseAdapter implements MouseMotionListener
        {
            

            @Override
            public void mousePressed(MouseEvent event)
            {
                a = event.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent event)
            {
                if (a != null && b !=null){
                    stroke.add(shape+""+color+""+a.x+""+a.y+""+b.x+""+b.y);
                }
                a = null;
                b = null;
            }

            @Override
            public void mouseDragged(MouseEvent event)
            {
                b = event.getPoint();
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent event)
            {
            }
        }

    }
}
