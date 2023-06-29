/*
 * Copyright (C) 2002-2011  Frédéric Bergeron (fbergeron@users.sourceforge.net)
 *                          and other contributors
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.fbergeron.solitaire;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.fbergeron.solitaire.Solitaire.NewGameListener;
import com.fbergeron.solitaire.Solitaire.RestartListener;
import com.fbergeron.util.*;


public class FrameCongratulations extends Frame
{
	protected Solitaire teste;
	
	public class NewGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           teste.newGame();
           teste.zerar();
           setVisible(false);
           
        }
    }
	public class closeGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
	
    public FrameCongratulations(long t1, long t2, int counter, Solitaire s)
    {
    	this.teste = s;
        setLayout(new BorderLayout(0,0));
        setSize(600,300);
        setVisible(false);
        setResizable(false);
        labelCongratulations.setAlignment(java.awt.Label.CENTER);
        labelCongratulations.setEnabled(false);
        labelCongratulations.setBackground(java.awt.Color.white);
        labelCongratulations.setForeground(java.awt.Color.red);
        labelCongratulations.setFont(new Font("Dialog", Font.PLAIN, 24));
        labelCongratulations.setBounds(0,0,200,100);
        
        
        Button b = new Button("New game");  
        b.setBounds(140,250,160,25);  
        b.addActionListener( new NewGameListener() );
        
        Button c = new Button("Quit");  
        c.setBounds(310,250,160,25);    
        c.addActionListener( new closeGameListener() );
        
        add(b); 
        add(c);
        add(BorderLayout.CENTER, labelCongratulations);

         
        
        long minutos = calculaTempo(t1, t2);
        minutos = minutos / 60;
        long segundos = calculaTempo(t1, t2);
        segundos = segundos % 60;
        
        String agora = " " + "Time: ";
        
        if (minutos<60) {
        	if(segundos<10) {
        		agora += "0" + minutos + ":0" + segundos;
        	}else {
        		agora += "0" + minutos + ":" + segundos;
        	}
        }else {
        	if(segundos<10) {
        		agora += "" + minutos + ":0" + segundos;
        	}else {
        		agora += "" + minutos + ":" + segundos;
        	}
        }
        
        agora+="!" + " ";
        String movimentos = "Moves: " + counter + "!";
        
        labelCongratulations.setText(Solitaire.resBundle.getString( "YouWon" ) + agora + movimentos);

        setTitle( (String)Solitaire.resBundle.getString( "Congratulations" ) );
        addWindowListener( new WindowManager( this, WindowManager.HIDE_ON_CLOSE ) );
    }

    /**
     * Shows or hides the component depending on the boolean flag b.
     * @param b  if true, show the component; otherwise, hide the component.
     * @see java.awt.Component#isVisible
     */
    
    public void setVisible(boolean b)
    {
        Dimension scrSize = getToolkit().getScreenSize();
        Dimension size = getSize();
        if(b)
        { 
            setLocation( (scrSize.width - size.width) / 2, (scrSize.height - size.height) / 2 );
        }
        super.setVisible(b);
    }
    
    public long calculaTempo(long t1, long t2) {
    	long resultado = t2-t1;
    	resultado = resultado/1000;
    	return resultado;
    }

    public void addNotify()
    {
        // Record the size of the window prior to calling parents addNotify.
        Dimension d = getSize();

        super.addNotify();

        if (fComponentsAdjusted)
            return;

        // Adjust components according to the insets
        setSize(getInsets().left + getInsets().right + d.width, getInsets().top + getInsets().bottom + d.height);
        Component components[] = getComponents();
        for (int i = 0; i < components.length; i++)
        {
            Point p = components[i].getLocation();
            p.translate(getInsets().left, getInsets().top);
            components[i].setLocation(p);
        }
        fComponentsAdjusted = true;
    }

    // Used for addNotify check.
    boolean fComponentsAdjusted = false;

    java.awt.Label labelCongratulations = new java.awt.Label();
    java.awt.Label labelTempo = new java.awt.Label();
    java.awt.Label labelMovimentos = new java.awt.Label();
}


