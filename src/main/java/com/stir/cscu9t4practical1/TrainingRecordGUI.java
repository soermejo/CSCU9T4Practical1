// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.LinkedHashMap; // import the HashMap class
import java.util.ArrayList; // import the ArrayList class


public class TrainingRecordGUI implements ActionListener {

    private JFrame frame;
    private final ButtonGroup bgSwim = new ButtonGroup();
    private JTextPane textPane = new JTextPane();
    private JComboBox cbActivity = new JComboBox();

    JRadioButton rbPool = new JRadioButton("Pool"); // Pool radio 
    JRadioButton rbOutdoor = new JRadioButton("Outdoor"); // Outdoor radio

    JComboBox cbTerrain = new JComboBox(); // Terrain dropdown menu
    JComboBox cbTempo = new JComboBox(); // Tempo dropdown menu


    // Buttons
    JButton btnAdd = new JButton("Add"); // Add entry button
    JButton btnLookup = new JButton("Look Up"); // Look up button
    JButton btnFindAll = new JButton("Find All"); // Find all button
    JButton btnRemove = new JButton("Remove"); // Remove button to be implemented

    // Text fields 
    JFormattedTextField tbDistance = new JFormattedTextField();
    JFormattedTextField tbSeconds = new JFormattedTextField();
    JFormattedTextField tbMinutes = new JFormattedTextField();
    JFormattedTextField tbHour = new JFormattedTextField();
    JFormattedTextField tbDay = new JFormattedTextField();
    JFormattedTextField tbMonth = new JFormattedTextField();
    JFormattedTextField tbYear = new JFormattedTextField();
    JFormattedTextField tbName = new JFormattedTextField();

    JFormattedTextField tbRecovery = new JFormattedTextField();
    JFormattedTextField tbLaps = new JFormattedTextField();

    private LinkedHashMap<Integer, ArrayList<JComponent>> jmap = new LinkedHashMap<>();
    private ArrayList<JFormattedTextField> jfields = new ArrayList<>();


    // Instance Training Record
    private TrainingRecord myAthletes = new TrainingRecord();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    // Set cross-platform Java L&F (also called "Metal")
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (UnsupportedLookAndFeelException e) {
                    // handle exception
                } catch (ClassNotFoundException e) {
                    // handle exception
                } catch (InstantiationException e) {
                    // handle exception
                } catch (IllegalAccessException e) {
                    // handle exception
                }

                try {
                    TrainingRecordGUI window = new TrainingRecordGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TrainingRecordGUI() {
        initialize();
        initializeListComponent();
    }

    private void initializeListComponent() {
        ArrayList<JComponent> jSwim = new ArrayList<>();
        ArrayList<JComponent> jCycle = new ArrayList<>();
        ArrayList<JComponent> jSprint = new ArrayList<>();
        ArrayList<JComponent> jRun = new ArrayList<>(); 

        jSwim.add(rbPool);
        jSwim.add(rbOutdoor);
        jmap.put(2, jSwim); // acrtivity 2 for swim

        jCycle.add(cbTerrain);
        jCycle.add(cbTempo);
        jmap.put(3, jCycle); // activity 3 for cycle

        jSprint.add(tbRecovery);
        jSprint.add(tbLaps);
        jmap.put(1, jSprint); // activity 1 for sprint

        jmap.put(0, jRun); // default so empty

        jDisableAll(); // Disable all as default is run

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 501, 548);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel pnlSwing = new JPanel();
        pnlSwing.setBorder(new LineBorder(new Color(0, 0, 0)));
        
		JLabel lblNewLabel_9 = new JLabel("Swim");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel pnlRun = new JPanel();
		pnlRun.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_9_1 = new JLabel("Sprint");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Cycle");
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_9_2 = new JLabel("Common data");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        
		JPanel panel_3 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 475, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_9)
										.addComponent(pnlSwing, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addComponent(pnlRun, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_9_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblNewLabel_9_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addComponent(lblNewLabel_9_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(lblNewLabel_9_1)
						.addComponent(lblNewLabel_9_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlSwing, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlRun, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		btnAdd.addActionListener(this); // Add to event listener
        btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
        btnLookup.addActionListener(this); // Add to event listener
        btnFindAll.addActionListener(this); // Add to event listener
        btnRemove.addActionListener(this); // Add to event listener
        btnRemove.setHorizontalAlignment(SwingConstants.RIGHT);
        
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(4)
					.addComponent(btnAdd)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLookup)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFindAll)
					.addGap(189)
					.addComponent(btnRemove)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnRemove)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFindAll)
						.addComponent(btnLookup)
						.addComponent(btnAdd))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		
		panel_3.add(textPane); 
        
        // Cycle add
		JLabel lblNewLabel_11 = new JLabel("Terrain");
		cbTerrain.setModel(new DefaultComboBoxModel(new String[] {"Gravel", "Asphalt", "Mountain"}));
		
		JLabel lblNewLabel_12 = new JLabel("Tempo");
        cbTempo.setModel(new DefaultComboBoxModel(new String[] {"Slow", "Moderate", "Fast"}));
        

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_11)
						.addComponent(lblNewLabel_12))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(cbTerrain, 0, 84, Short.MAX_VALUE)
						.addComponent(cbTempo, 0, 84, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(cbTerrain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbTempo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_12)))
						.addComponent(lblNewLabel_11, Alignment.LEADING))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
        
        // Sprint add 
		JLabel lblNewLabel_10 = new JLabel("Recovery (minutes)"); // Recovery time in minutes
        tbRecovery.setColumns(3);
        jfields.add(tbRecovery); //add tb recovery to jfields
		
		JLabel lblNewLabel_13 = new JLabel("Laps"); // Laps 
        tbLaps.setColumns(3);
        jfields.add(tbLaps); //add tb recovery to jfields
        

		GroupLayout gl_pnlRun = new GroupLayout(pnlRun);
		gl_pnlRun.setHorizontalGroup(
			gl_pnlRun.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlRun.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlRun.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlRun.createSequentialGroup()
							.addComponent(lblNewLabel_10)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tbRecovery, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlRun.createSequentialGroup()
							.addComponent(lblNewLabel_13)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tbLaps, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlRun.setVerticalGroup(
			gl_pnlRun.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlRun.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlRun.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_10)
						.addComponent(tbRecovery, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlRun.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_13)
						.addComponent(tbLaps, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlRun.setLayout(gl_pnlRun);
        
        // Swim add 
		bgSwim.add(rbPool);
        bgSwim.add(rbOutdoor);
        
		GroupLayout gl_pnlSwing = new GroupLayout(pnlSwing);
		gl_pnlSwing.setHorizontalGroup(
			gl_pnlSwing.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSwing.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlSwing.createParallelGroup(Alignment.LEADING)
						.addComponent(rbPool)
						.addComponent(rbOutdoor))
					.addContainerGap(657, Short.MAX_VALUE))
		);
		gl_pnlSwing.setVerticalGroup(
			gl_pnlSwing.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSwing.createSequentialGroup()
					.addContainerGap()
					.addComponent(rbPool)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rbOutdoor)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		pnlSwing.setLayout(gl_pnlSwing);
        
        
        // Activity dropdown menu
		JLabel lblNewLabel_8 = new JLabel("Activity");
        cbActivity.setModel(new DefaultComboBoxModel(new String[] {"Run", "Sprint", "Swim", "Cycle"}));
        
        cbActivity.addActionListener(this); // Add dropdown activity menu to event listener
		
		JLabel lblNewLabel = new JLabel("Name");
        tbName.setColumns(30);
        jfields.add(tbName); // add to jfields
		
		JLabel lblNewLabel_1 = new JLabel("Year");
        tbYear.setColumns(4);
        jfields.add(tbYear);
		
		JLabel lblNewLabel_2 = new JLabel("Month");
        tbMonth.setColumns(2);
        jfields.add(tbMonth); // add to jfields
		
		JLabel lblNewLabel_3 = new JLabel("Day");		
        tbDay.setColumns(2);
        jfields.add(tbDay); // add to jfields
		
		JLabel lblNewLabel_4 = new JLabel("Hour");	
        tbHour.setColumns(2);
        jfields.add(tbHour); // add to jfields
		
		JLabel lblNewLabel_5 = new JLabel("Minutes");	
        tbMinutes.setColumns(2);
        jfields.add(tbMinutes); // add to jfields
		
		JLabel lblNewLabel_6 = new JLabel("Seconds");	
        tbSeconds.setColumns(2);
        jfields.add(tbSeconds); // add to jfields
		
        JLabel lblNewLabel_7 = new JLabel("Distance (meters)");
        tbDistance.setColumns(6);
        jfields.add(tbDistance); // add to jfields


		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_8)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbActivity, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addGap(4)
							.addComponent(tbHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblNewLabel_5)
							.addGap(4)
							.addComponent(tbMinutes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblNewLabel_6)
							.addGap(4)
							.addComponent(tbSeconds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblNewLabel_7)
							.addGap(4)
							.addComponent(tbDistance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tbName, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addGap(4)
							.addComponent(tbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblNewLabel_2)
							.addGap(4)
							.addComponent(tbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblNewLabel_3)
							.addGap(4)
							.addComponent(tbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(308))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(tbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2))
						.addComponent(tbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3))
						.addComponent(tbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tbName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_8)
							.addComponent(cbActivity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_4))
						.addComponent(tbHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5))
						.addComponent(tbMinutes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_6))
						.addComponent(tbSeconds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_7))
						.addComponent(tbDistance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	}
    
    private void jDisableAll() {
        for (ArrayList<JComponent> jl: jmap.values()) {
            for (JComponent j: jl) {
                j.setEnabled(false);
            }
        }
    }

    private void jEnable(int jType) {
        jDisableAll(); // Disable all the controls
        for (JComponent j: jmap.get(jType)) {
            j.setEnabled(true);
        }
    }


	@Override
	public void actionPerformed(ActionEvent event) {
        System.out.println(event.getSource());
        String message = "";
        Integer currentEntry = cbActivity.getSelectedIndex();
        
        // Activity
        if (event.getSource() == cbActivity) {
            System.out.println("cbActivity fired up!");
            System.out.println(cbActivity.getSelectedIndex());
            jEnable(cbActivity.getSelectedIndex());
        }
       

       // buttons events
       if (event.getSource() instanceof JButton) {
           if (event.getSource() == btnAdd) {
                message = addEntry(currentEntry.toString());
           } else if (event.getSource() == btnFindAll) {
                message = findallEntry();
           } else if (event.getSource() == btnLookup) {
                message = lookupEntry();
           }
           blankDisplay(); // clear display
       }

       textPane.setText(message); // Show output 
		
    }

    public String addEntry(String what) {
        String message;
        int m, d, y;
        System.out.println("Trying to add "+what+" entry to the records");
        String n = tbName.getText();

        if (n.isEmpty()) {
            return "Name is empty! ";
        }

        try {
            m = Integer.parseInt(tbMonth.getText());
            d = Integer.parseInt(tbDay.getText());
            y = Integer.parseInt(tbYear.getText());

        } catch (NumberFormatException e) {
            return "You must enter an integer!";
        }

        float km = java.lang.Float.parseFloat(tbDistance.getText());
        int h = Integer.parseInt(tbHour.getText());
        int mm = Integer.parseInt(tbMinutes.getText());
        int s = Integer.parseInt(tbSeconds.getText());
        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        message = myAthletes.addEntry(e);
        return message;
    }

    public String lookupEntry() {
        int m = Integer.parseInt(tbMonth.getText());
        int d = Integer.parseInt(tbDay.getText());
        int y = Integer.parseInt(tbYear.getText());
        // outputArea.setText("looking up record ..."); // useless. not working.
        // String message = myAthletes.lookupEntry(d, m, y); //  we can return directly the value
        return myAthletes.lookupEntry(d, m, y);
    }

    public String findallEntry() {
        int m = Integer.parseInt(tbMonth.getText());
        int d = Integer.parseInt(tbDay.getText());
        int y = Integer.parseInt(tbYear.getText());
        return myAthletes.findallEntry(d, m, y);
    }
    

    public void blankDisplay() {
        for (JFormattedTextField j: jfields) {
            j.setText("");
        }
    }
}
