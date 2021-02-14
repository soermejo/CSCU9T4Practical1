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
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.LinkedHashMap; // import the HashMap class
import java.util.regex.Pattern;
import java.util.ArrayList; // import the ArrayList class

public class TrainingRecordGUI implements ActionListener {

	private JFrame frame;
	private Pattern numPattern = Pattern.compile("^[+]?\\d+([.]\\d+)?$"); // numbers only re pattern
	private Pattern positiveIntPattern = Pattern.compile("^[0-9]\\d*$"); // positive numbers re pattern excluding 0
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
	JButton btnRemove = new JButton("Remove"); // Remove button
	JButton btnWDist = new JButton("Weekly Distance"); // Remove button

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

	/**
	 * Initialize the list of components in order to show and hide each acivity when
	 * each acivity is selected from the menu cbActivity.
	 */
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
	 * Initialize the contents of the frame. I helped myself using eclipse disegner
	 * to properly design the GUI as the default interface was not suitable to
	 * rappresent all of these feature which would have been too much messy. I added
	 * some GUI input controls with the setFormatterFactory method using
	 * JTextFormattedField instead of JTextField In this way i can avoid checking
	 * more inputs failure in the backend
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
						.addGroup(Alignment.LEADING,
								gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(
												gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 475,
																		Short.MAX_VALUE)
																.addContainerGap())
														.addGroup(gl_panel
																.createSequentialGroup()
																.addComponent(
																		panel_3, GroupLayout.PREFERRED_SIZE, 473,
																		GroupLayout.PREFERRED_SIZE)
																.addContainerGap())
														.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
																.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel.createSequentialGroup()
																		.addGroup(gl_panel
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblNewLabel_9)
																				.addComponent(pnlSwing,
																						GroupLayout.PREFERRED_SIZE, 88,
																						GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(gl_panel
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblNewLabel_9_1,
																						GroupLayout.PREFERRED_SIZE, 43,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(pnlRun,
																						GroupLayout.DEFAULT_SIZE, 225,
																						Short.MAX_VALUE))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(gl_panel
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblNewLabel_9_1_1,
																						GroupLayout.PREFERRED_SIZE, 30,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(panel_2,
																						GroupLayout.PREFERRED_SIZE, 150,
																						GroupLayout.PREFERRED_SIZE)))
																.addComponent(lblNewLabel_9_2,
																		GroupLayout.PREFERRED_SIZE, 92,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 474,
																		GroupLayout.PREFERRED_SIZE))
																.addContainerGap()))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(14).addComponent(lblNewLabel_9_2)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_9)
								.addComponent(lblNewLabel_9_1).addComponent(lblNewLabel_9_1_1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlSwing, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnlRun, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE).addContainerGap()));

		btnAdd.addActionListener(this); // Add to event listener
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnLookup.addActionListener(this); // Add to event listener
		btnFindAll.addActionListener(this); // Add to event listener
		btnRemove.addActionListener(this); // Add to event listener
		btnWDist.addActionListener(this); // Add to event listener
		btnRemove.setHorizontalAlignment(SwingConstants.RIGHT);

		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addGap(4).addComponent(btnAdd)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLookup)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnFindAll)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnWDist).addGap(70) // .addGap(189)
						.addComponent(btnRemove).addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap().addComponent(btnRemove)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						gl_panel_4.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(btnWDist)
										.addComponent(btnFindAll).addComponent(btnLookup).addComponent(btnAdd))
								.addContainerGap()));
		panel_4.setLayout(gl_panel_4);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		panel_3.add(textPane);

		// Cycle add
		JLabel lblNewLabel_11 = new JLabel("Terrain");
		cbTerrain.setModel(new DefaultComboBoxModel(new String[] { "Gravel", "Asphalt", "Mountain" }));

		JLabel lblNewLabel_12 = new JLabel("Tempo");
		cbTempo.setModel(new DefaultComboBoxModel(new String[] { "Slow", "Moderate", "Fast" }));

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2
				.setHorizontalGroup(
						gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_11).addComponent(lblNewLabel_12))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addComponent(cbTerrain, 0, 84, Short.MAX_VALUE)
												.addComponent(cbTempo, 0, 84, Short.MAX_VALUE))
										.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_2.createSequentialGroup().addContainerGap().addGroup(gl_panel_2
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(cbTerrain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(cbTempo, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_12)))
						.addComponent(lblNewLabel_11, Alignment.LEADING)).addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		// Sprint add
		JLabel lblNewLabel_10 = new JLabel("Recovery (minutes)"); // Recovery time in minutes
		tbRecovery.setColumns(3);
		jfields.add(tbRecovery); // add tb recovery to jfields
		javax.swing.text.NumberFormatter recoveryFormatter = new javax.swing.text.NumberFormatter(
				new java.text.DecimalFormat("##"));
		tbRecovery.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(recoveryFormatter));

		JLabel lblNewLabel_13 = new JLabel("Laps"); // Laps
		tbLaps.setColumns(3);
		jfields.add(tbLaps); // add tb recovery to jfields
		javax.swing.text.NumberFormatter lapsFormatter = new javax.swing.text.NumberFormatter(
				new java.text.DecimalFormat("##"));
		tbLaps.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(lapsFormatter));

		GroupLayout gl_pnlRun = new GroupLayout(pnlRun);
		gl_pnlRun.setHorizontalGroup(gl_pnlRun.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlRun.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlRun.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlRun.createSequentialGroup().addComponent(lblNewLabel_10)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(tbRecovery,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlRun.createSequentialGroup().addComponent(lblNewLabel_13)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(tbLaps,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_pnlRun.setVerticalGroup(gl_pnlRun.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlRun
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnlRun.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_10).addComponent(
						tbRecovery, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_pnlRun.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_13).addComponent(
						tbLaps, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		pnlRun.setLayout(gl_pnlRun);

		// Swim add
		bgSwim.add(rbPool);
		bgSwim.add(rbOutdoor);

		// Action command
		rbPool.setActionCommand("pool");
		rbOutdoor.setActionCommand("outdoor");

		// Set radio button pool as default
		rbPool.setSelected(true);

		GroupLayout gl_pnlSwing = new GroupLayout(pnlSwing);
		gl_pnlSwing.setHorizontalGroup(gl_pnlSwing.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSwing
						.createSequentialGroup().addContainerGap().addGroup(gl_pnlSwing
								.createParallelGroup(Alignment.LEADING).addComponent(rbPool).addComponent(rbOutdoor))
						.addContainerGap(657, Short.MAX_VALUE)));
		gl_pnlSwing.setVerticalGroup(gl_pnlSwing.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSwing.createSequentialGroup().addContainerGap().addComponent(rbPool)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rbOutdoor)
						.addContainerGap(28, Short.MAX_VALUE)));
		pnlSwing.setLayout(gl_pnlSwing);

		// Activity dropdown menu
		JLabel lblNewLabel_8 = new JLabel("Activity");
		cbActivity.setModel(new DefaultComboBoxModel(new String[] { "Run", "Sprint", "Swim", "Cycle" }));

		cbActivity.addActionListener(this); // Add dropdown activity menu to event listener

		JLabel lblNewLabel = new JLabel("Name");
		tbName.setColumns(30);
		jfields.add(tbName); // add to jfields

		JLabel lblNewLabel_1 = new JLabel("Year");
		tbYear.setColumns(4);
		javax.swing.text.NumberFormatter yearFormatter = new javax.swing.text.NumberFormatter(
				new java.text.DecimalFormat("##"));
		yearFormatter.setMaximum(9999);
		tbYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(yearFormatter));

		jfields.add(tbYear);

		JLabel lblNewLabel_2 = new JLabel("Month");
		tbMonth.setColumns(2);
		javax.swing.text.NumberFormatter monthFormatter = new javax.swing.text.NumberFormatter(
				new java.text.DecimalFormat("##"));
		monthFormatter.setMaximum(12);
		monthFormatter.setMinimum(1);
		tbMonth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(monthFormatter));
		jfields.add(tbMonth); // add to jfields

		JLabel lblNewLabel_3 = new JLabel("Day");
		tbDay.setColumns(2);
		javax.swing.text.NumberFormatter dayFormatter = new javax.swing.text.NumberFormatter(
				new java.text.DecimalFormat("##"));
		dayFormatter.setMaximum(31);
		dayFormatter.setMinimum(1);
		tbDay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(dayFormatter));
		jfields.add(tbDay); // add to jfields

		JLabel lblNewLabel_4 = new JLabel("Hour");
		tbHour.setColumns(2);
		javax.swing.text.NumberFormatter hourFormatter = new javax.swing.text.NumberFormatter(
				new java.text.DecimalFormat("##"));
		hourFormatter.setMaximum(23);
		hourFormatter.setMinimum(0);
		tbHour.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(hourFormatter));
		jfields.add(tbHour); // add to jfields

		JLabel lblNewLabel_5 = new JLabel("Minutes");
		tbMinutes.setColumns(2);
		javax.swing.text.NumberFormatter minSecFormatter = new javax.swing.text.NumberFormatter(
				new java.text.DecimalFormat("##"));
		minSecFormatter.setMaximum(59);
		minSecFormatter.setMinimum(0);
		tbMinutes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(minSecFormatter));
		jfields.add(tbMinutes); // add to jfields

		JLabel lblNewLabel_6 = new JLabel("Seconds");
		tbSeconds.setColumns(2);
		tbSeconds.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(minSecFormatter));
		jfields.add(tbSeconds); // add to jfields

		JLabel lblNewLabel_7 = new JLabel("Distance (Km)");
		tbDistance.setColumns(6);
		javax.swing.text.NumberFormatter distanceFormatter = new javax.swing.text.NumberFormatter(
				new java.text.DecimalFormat("#.###"));
		tbDistance.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(distanceFormatter));
		jfields.add(tbDistance); // add to jfields

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_8)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cbActivity, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_4).addGap(4)
								.addComponent(tbHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(4).addComponent(lblNewLabel_5).addGap(4)
								.addComponent(tbMinutes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(4).addComponent(lblNewLabel_6).addGap(4)
								.addComponent(tbSeconds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(4).addComponent(lblNewLabel_7).addGap(4).addComponent(tbDistance,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_panel_1.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tbName, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1)
										.addGap(4)
										.addComponent(tbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4).addComponent(lblNewLabel_2).addGap(4)
										.addComponent(tbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4).addComponent(lblNewLabel_3).addGap(4).addComponent(tbDay,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
				.addGap(308)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblNewLabel))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblNewLabel_1))
								.addComponent(tbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblNewLabel_2))
								.addComponent(tbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblNewLabel_3))
								.addComponent(tbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tbName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_8)
										.addComponent(cbActivity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblNewLabel_4))
								.addComponent(tbHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblNewLabel_5))
								.addComponent(tbMinutes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblNewLabel_6))
								.addComponent(tbSeconds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblNewLabel_7))
								.addComponent(tbDistance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(13)));
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	}

	/**
	 * Get the selection from Swim
	 * 
	 * @return String (containing the selection from the bgSwim radio buttons)
	 */
	public String getSelectedSwim() {
		return this.bgSwim.getSelection().getActionCommand();

	}

	/**
	 * Backend int check additional controll
	 * 
	 * @param strNum
	 * @return boolean true if numeric false if not
	 */
	public boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		return numPattern.matcher(strNum).matches();
	}

	/**
	 * Check for number to be positive to check date
	 * 
	 * @param strNum
	 * @return boolean true if numeric false if not
	 */
	public boolean isPositive(String strNum) {
		if (strNum == null) {
			return false;
		}

		return positiveIntPattern.matcher(strNum).matches();
	}

	/**
	 * Disable all the widgets but leaving the defaults common widgets enabled
	 */
	private void jDisableAll() {
		for (ArrayList<JComponent> jl : jmap.values()) {
			for (JComponent j : jl) {
				j.setEnabled(false);
			}
		}
	}

	/**
	 * Enable the specific widgets for the selected activity
	 * 
	 * @param jType (the selected activity)
	 */
	private void jEnable(int jType) {
		jDisableAll(); // Disable all the controls
		for (JComponent j : jmap.get(jType)) {
			j.setEnabled(true);
		}
	}

	/**
	 * Handler for all the action performed in the GUI
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		String message = "";
		Integer currentEntry = cbActivity.getSelectedIndex();

		// Activity
		if (event.getSource() == cbActivity) {
			System.out.println("cbActivity fired up!");
			jEnable(cbActivity.getSelectedIndex()); // enable the fired activity controls
		}

		// buttons events
		if (event.getSource() instanceof JButton) {
			if (event.getSource() == btnAdd) {
				message = validateInput(currentEntry);
				if (message.equals("ok"))
					message = addEntry(currentEntry);
			} else if (event.getSource() == btnFindAll) {
				message = checkBlankInput("findall");
				if (message.equals("ok"))
					message = findallEntry();
			} else if (event.getSource() == btnLookup) {
				message = checkBlankInput("lookup");
				if (message.equals("ok"))
					message = lookupEntry();
			} else if (event.getSource() == btnRemove) {
				message = checkBlankInput("remove");
				if (message.equals("ok"))
					message = removeEntry();
			} else if (event.getSource() == btnWDist) {
				message = checkBlankInput("weeklydistance");
				if (message.equals("ok"))
					message = weeklyDistance();
			}
			blankDisplay(); // clear display
		}

		textPane.setText(message); // Show output

	}

	/**
	 * This method dispatch the selected entry to the proper entry type and then
	 * return it.
	 * 
	 * @param entityType Activity type (0 - generic/run , 1 - sprint, 2 - swim, 3 -
	 *                   cycle)
	 * @param n          Athlete name
	 * @param d          day
	 * @param m          month
	 * @param y          year
	 * @param h          hour
	 * @param mm         min
	 * @param s          sec
	 * @param km         distance
	 * @return Entry object
	 */
	public Entry dispatchEntry(Integer entityType, String n, int d, int m, int y, int h, int mm, int s, float km) {
		Entry entry = null; // need initilization

		switch (entityType) {
			case 0: // Run
				entry = new Entry(n, d, m, y, h, mm, s, km);
				break;

			case 1: // Sprint
				int recover = Integer.parseInt(tbRecovery.getText());
				int laps = Integer.parseInt(tbLaps.getText());
				entry = new SprintEntry(n, d, m, y, h, mm, s, km, laps, recover);
				break;

			case 2: // Swim
				String where = getSelectedSwim();
				entry = new SwimEntry(n, d, m, y, h, mm, s, km, where);
				break;

			case 3: // Cycle
				String tempo = cbTempo.getSelectedItem().toString();
				String terrain = cbTerrain.getSelectedItem().toString();
				entry = new CycleEntry(n, d, m, y, h, mm, s, km, terrain, tempo);
				break;

			default:
				break;
		}

		return entry;

	}

	/**
	 * Check for blank input for each performed action or pressed buttons.
	 * 
	 * @param op operation performed
	 * @return String (result of operation)
	 */
	public String checkBlankInput(String op) {
		boolean res = false;
		if (op.equals("lookup")) {
			res = !(tbDay.getText().isBlank() || tbMonth.getText().isBlank() || tbYear.getText().isBlank());
		} else if (op.equals("findall")) {
			res = !(tbDay.getText().isBlank() || tbMonth.getText().isBlank() || tbYear.getText().isBlank());
		} else if (op.equals("weeklydistance")) {
			res = !(tbName.getText().isBlank());
		} else if (op.equals("remove")) {
			res = !(tbName.getText().isBlank() || tbDay.getText().isBlank() || tbMonth.getText().isBlank()
					|| tbYear.getText().isBlank());
		}

		if (!res) {
			return "You need to input all the required fields.";
		}
		return "ok";

	}

	/**
	 * Check the black inputs for each entity type.
	 * 
	 * @param entityType
	 * @return String (result of operation)
	 */
	public String checkBlankInput(int entityType) {

		boolean res = !(tbName.getText().isBlank() || tbDistance.getText().isBlank() || tbSeconds.getText().isBlank()
				|| tbMinutes.getText().isBlank() || tbHour.getText().isBlank() || tbDay.getText().isBlank()
				|| tbMonth.getText().isBlank() || tbYear.getText().isBlank());

		if (entityType == 1) { // Sprint
			res = res && !(tbRecovery.getText().isBlank() || tbLaps.getText().isBlank());
		}

		if (!res) {
			return "You need to input all the required fields.";
		}
		return "ok";

	}

	/**
	 * Check Input to be numeric for each entity type.
	 * 
	 * @param entityType
	 * @return String (result of operation)
	 */
	public String checkIntInput(int entityType) {
		boolean res = (isNumeric(tbSeconds.getText())
				&& isNumeric(tbMinutes.getText()) && isNumeric(tbHour.getText()) && isNumeric(tbDay.getText())
				&& isNumeric(tbMonth.getText()) && isNumeric(tbYear.getText()));

		if (entityType == 1) { // Sprint
			res = res && (isNumeric(tbRecovery.getText()) && isNumeric(tbLaps.getText()));
		}

		if (!res) {
			return "You must input a numeric value.";
		}
		return "ok";
	}

	/**
	 * Date validation. Check to be > 0
	 * 
	 * @return String (result of operation)
	 */
	public String checkDateValidation() {
		boolean res = (isPositive(tbSeconds.getText()) && isPositive(tbMinutes.getText())
				&& isPositive(tbHour.getText()) && isPositive(tbDay.getText()) && isPositive(tbMonth.getText())
				&& isPositive(tbYear.getText()));
		if (res)
			return "ok";
		return "Date is invalid.";
	}

	/**
	 * All the inputs validator.
	 * 
	 * @param entityType
	 * @return String (result of operation)
	 */
	public String validateInput(int entityType) {
		String message;
		message = checkBlankInput(entityType); // Blank check
		if (message.equals("ok"))
			message = checkIntInput(entityType); // Number validation
		if (message.equals("ok"))
			message = checkDateValidation(); // Date validation
		return message;
	}

	/**
	 * Add specific entry.
	 * 
	 * @param entityType Entity type (0 - generic/run , 1 - sprint, 2 - swim, 3 -
	 *                   cycle)
	 * @return String (result of operation)
	 */
	public String addEntry(Integer entityType) {
		String message;
		int m, d, y;
		System.out.println("Trying to add " + entityType + " entry to the records");
		String n = tbName.getText();

		m = Integer.parseInt(tbMonth.getText());
		d = Integer.parseInt(tbDay.getText());
		y = Integer.parseInt(tbYear.getText());

		String kmStr = tbDistance.getText();
		if (kmStr.contains(",")) 
			kmStr = kmStr.replace(",", ".");
			
		float km = java.lang.Float.parseFloat(kmStr);
		int h = Integer.parseInt(tbHour.getText());
		int mm = Integer.parseInt(tbMinutes.getText());
		int s = Integer.parseInt(tbSeconds.getText());

		Entry e = dispatchEntry(entityType, n, d, m, y, h, mm, s, km);
		message = myAthletes.addEntry(e);
		return message;
	}

	/**
	 * Look up single entry by date.
	 * 
	 * @return String (result of operation)
	 */
	public String lookupEntry() {
		int m = Integer.parseInt(tbMonth.getText());
		int d = Integer.parseInt(tbDay.getText());
		int y = Integer.parseInt(tbYear.getText());
		// outputArea.setText("looking up record ..."); // useless. not working.
		// String message = myAthletes.lookupEntry(d, m, y); // we can return directly
		// the value
		return myAthletes.lookupEntry(d, m, y);
	}

	/**
	 * Find all the entries by date.
	 * 
	 * @return String (result of operation)
	 */
	public String findallEntry() {
		int m = Integer.parseInt(tbMonth.getText());
		int d = Integer.parseInt(tbDay.getText());
		int y = Integer.parseInt(tbYear.getText());
		return myAthletes.findallEntry(d, m, y);
	}

	/**
	 * Remove single entry by name and date.
	 * 
	 * @return String (result of operation)
	 */
	public String removeEntry() {
		String name = tbName.getText();
		int m = Integer.parseInt(tbMonth.getText());
		int d = Integer.parseInt(tbDay.getText());
		int y = Integer.parseInt(tbYear.getText());
		return myAthletes.removeEntry(name, d, m, y);
	}

	/**
	 * Find the weekly distance by name achieved by the athlete.
	 * 
	 * @return String (result of operation)
	 */
	public String weeklyDistance() {
		String name = tbName.getText();
		return myAthletes.weeklyDistance(name);
	}

	/**
	 * Clear all the inputs.
	 */
	public void blankDisplay() {
		for (JFormattedTextField j : jfields) {
			j.setText("");
		}
	}

	/**
	 * Method used to perform unit test set each text input automatically
	 * 
	 * @param ent Entry object
	 */
	public void fillDisplay(Entry ent) {
		tbName.setText(ent.getName());
		tbDay.setText(String.valueOf(ent.getDay()));
		tbMonth.setText(String.valueOf(ent.getMonth()));
		tbYear.setText(String.valueOf(ent.getYear()));
		tbHour.setText(String.valueOf(ent.getHour()));
		tbMinutes.setText(String.valueOf(ent.getMin()));
		tbSeconds.setText(String.valueOf(ent.getSec()));
		tbDistance.setText(String.valueOf(ent.getDistance()));
	}
}
