import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class KlacikSACAPframe extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel childPanel = new JPanel();
	private final JPanel applicantPanel = new JPanel();
	private final JPanel financialPanel = new JPanel();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenuItem mntmStartNewForm = new JMenuItem("Start New Form");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JSeparator separator = new JSeparator();
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmApplicantInfoHelp = new JMenuItem("Applicant Info Help");
	private final JMenuItem mntmChildInfoHelp = new JMenuItem("Child Info Help");
	private final JMenuItem mntmFinancialInfoHelp = new JMenuItem("Financial Info Help");
	private final JLabel lblFirstNameChild = new JLabel("First Name: ");
	private final JTextField fNameChildTF = new JTextField();
	private final JLabel lblGender = new JLabel("Gender: ");
	private final JRadioButton rdbtnMale = new JRadioButton("Male");
	private final JRadioButton rdbtnFemale = new JRadioButton("Female");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblBirthdate = new JLabel("Birthdate: ");
	private final JFormattedTextField birthFTF = new JFormattedTextField();
	MaskFormatter birthMask = createFormatter("##/##/##");
	private final JComboBox clothingCB = new JComboBox();
	private final JLabel lblClothingSize = new JLabel("Clothing Size:");
	private final JLabel lblShoeSize = new JLabel("Shoe Size:");
	private final JTextField shoeTF = new JTextField();
	private final JLabel lblCoatSize = new JLabel("Coat Size: ");
	private final JTextField coatTF = new JTextField();
	private final JLabel lblGameSystems = new JLabel("Game Systems: ");
	private final JList interestList = new JList();
	private final JLabel lblInterests = new JLabel("Interests:");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextField interestTF = new JTextField();
	private final JLabel lblOtherinterests = new JLabel("Other Interests:");
	private final JLabel lblChild = new JLabel("Child:");
	private final JComboBox childCB = new JComboBox();
	private final JButton btnNewChild = new JButton("New Child");
	private final JButton btnRemoveChild = new JButton("Remove Child");
	private final JLabel lblFirstNameApp = new JLabel("First Name: ");
	private final JTextField fNameAppTF = new JTextField();
	private final JLabel lblLastName = new JLabel("Last Name: ");
	private final JTextField lNameTF = new JTextField();
	private final JLabel lblAddress = new JLabel("Address: ");
	private final JTextField addressTF = new JTextField();
	private final JLabel lblPostalCode = new JLabel("Postal Code:");
	MaskFormatter postMask = createFormatter("#####");
	private final JFormattedTextField postCodeFTF = new JFormattedTextField();
	private final JLabel lblPhoneNumber = new JLabel("Phone Number: ");
	MaskFormatter phoneMask = createFormatter("(###)###-####");
	private final JFormattedTextField phoneNumFTF = new JFormattedTextField();
	private final JLabel lblEmail = new JLabel("Email: ");
	private final JTextField emailTF = new JTextField();
	private final JLabel lblOfAdults = new JLabel("# of Adults: ");
	private final JLabel lblOfChildren = new JLabel("# of Children 18+: ");
	private final JLabel lblOfChildren_1 = new JLabel("# of Children 0-17: ");
	private final JLabel lblCity = new JLabel("City:");
	private final JComboBox cityCB = new JComboBox();
	private final JLabel lblEmployment = new JLabel("Employment: ");
	private final JLabel lblChildspousalSupport = new JLabel("Child/Spousal Support:");
	private final JLabel lblOntarioWorks = new JLabel("Ontario Works:");
	private final JLabel lblEiOrDisability = new JLabel("E.I. or Disability: ");
	private final JLabel lblPensionIncome = new JLabel("Pension Income:");
	private final JLabel lblChildTaxCredits = new JLabel("Child Tax Credits: ");
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	private final JFormattedTextField supportFTF = new JFormattedTextField(currencyFormat);
	private final JFormattedTextField empFTF = new JFormattedTextField(currencyFormat);
	private final JFormattedTextField worksFTF = new JFormattedTextField(currencyFormat);
	private final JFormattedTextField eiFTF = new JFormattedTextField(currencyFormat);
	private final JFormattedTextField pensionFTF = new JFormattedTextField(currencyFormat);
	private final JFormattedTextField creditsFTF = new JFormattedTextField(currencyFormat);
	private final JLabel lblGasHydro = new JLabel("Gas + Hydro:");
	private final JFormattedTextField gasFTF = new JFormattedTextField(currencyFormat);
	private final JLabel lblPhoneTv = new JLabel("Phone + TV: ");
	private final JFormattedTextField phoneFTF = new JFormattedTextField(currencyFormat);
	private final JLabel lblChildCare = new JLabel("Child Care:");
	private final JFormattedTextField childCareFTF = new JFormattedTextField(currencyFormat);
	private final JLabel lblLoansInsurance = new JLabel("Loans + Insurance:");
	private final JFormattedTextField loansFTF = new JFormattedTextField(currencyFormat);
	private final JFormattedTextField transitGasFTF = new JFormattedTextField(currencyFormat);
	private final JFormattedTextField rentMortgageFTF = new JFormattedTextField(currencyFormat);
	private final JCheckBox chckbxRent = new JCheckBox("Rent");
	private final JCheckBox chckbxMortgage = new JCheckBox("Mortgage:");
	private final JCheckBox chckbxTransit = new JCheckBox("Transit");
	private final JCheckBox chckbxGas = new JCheckBox("Gas:");
	private final JLabel lblIncome = new JLabel("Income");
	private final JLabel lblExpenses = new JLabel("Expenses");
	private final JLabel lblTotalIncome = new JLabel("Total Income: $0");
	private final JLabel lblTotalExpenses = new JLabel("Total Expenses: $0");
	ArrayList<Child> children = new ArrayList<Child>();
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
	NumberFormat numFormat = NumberFormat.getNumberInstance();
	private final JList gameList = new JList();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JLabel lblNetIncome = new JLabel("Net Income: $0");
	private final JSpinner AdultSpinner = new JSpinner();
	private final JSpinner oldChildrenSpinner = new JSpinner();
	private final JSpinner youngChildrenSpinner = new JSpinner();
	int currentTabIndex;
	int currentChildNum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KlacikSACAPframe frame = new KlacikSACAPframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MaskFormatter createFormatter(String s) {
	     MaskFormatter formatter = null;
	     try {
	          formatter = new MaskFormatter(s);
	         } 
	     catch (java.text.ParseException exc) {
		          System.err.println("formatter is bad: " + exc.getMessage());
		          System.exit(-1);
		      }
	      return formatter;
	}//createFormatter

	/**
	 * Create the frame.
	 */
	public KlacikSACAPframe() {
		emailTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_emailTF_focusLost(e);
			}
		});
		emailTF.setToolTipText("Enter your email");
		emailTF.setBounds(119, 201, 86, 20);
		emailTF.setColumns(10);
		phoneNumFTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_phoneNumFTF_focusLost(e);
			}
		});
		phoneNumFTF.setToolTipText("Enter your phone number");
		phoneNumFTF.setBounds(119, 176, 86, 20);
		phoneNumFTF.setColumns(10);
		postCodeFTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_postCodeFTF_focusLost(e);
			}
		});
		postCodeFTF.setToolTipText("Enter your postal code");
		postCodeFTF.setBounds(119, 120, 86, 20);
		postCodeFTF.setColumns(10);
		addressTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_addressTF_focusLost(e);
			}
		});
		addressTF.setToolTipText("Enter your address");
		addressTF.setBounds(119, 94, 143, 20);
		addressTF.setColumns(10);
		lNameTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_lNameTF_focusLost(e);
			}
		});
		lNameTF.setToolTipText("Enter your last name");
		lNameTF.setBounds(119, 66, 86, 20);
		lNameTF.setColumns(10);
		fNameAppTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_fNameAppTF_focusLost(e);
			}
		});
		fNameAppTF.setToolTipText("Enter your first name");
		fNameAppTF.setBounds(119, 38, 86, 20);
		fNameAppTF.setColumns(10);
		interestTF.setToolTipText("Enter any other interests your child has that aren't listed above");
		interestTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_interestTF_focusLost(e);
			}
		});
		interestTF.setBounds(362, 310, 86, 20);
		interestTF.setColumns(10);
		coatTF.setToolTipText("Enter your child's coat size");
		coatTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_coatTF_focusLost(e);
			}
		});
		coatTF.setBounds(95, 300, 86, 20);
		coatTF.setColumns(10);
		shoeTF.setToolTipText("Enter your child's shoe size");
		shoeTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_shoeTF_focusLost(e);
			}
		});
		shoeTF.setBounds(95, 274, 86, 20);
		shoeTF.setColumns(10);
		fNameChildTF.setToolTipText("Enter the child's first name");
		fNameChildTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_fNameChildTF_focusLost(arg0);
			}
		});
		fNameChildTF.setBounds(95, 100, 86, 20);
		fNameChildTF.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Klacik Salvation Army Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmStartNewForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmStartNewForm_actionPerformed(e);
			}
		});
		
		mnFile.add(mntmStartNewForm);
		
		mnFile.add(separator);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnHelp);
		mntmApplicantInfoHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmApplicantInfoHelp_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmApplicantInfoHelp);
		mntmChildInfoHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmChildInfoHelp_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmChildInfoHelp);
		mntmFinancialInfoHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmFinacialInfoHelp_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmFinancialInfoHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane.setBounds(10, 11, 564, 418);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				do_tabbedPane_stateChanged(arg0);
			}
		});
		contentPane.add(tabbedPane);
		
		tabbedPane.addTab("Applicant Info", null, applicantPanel, null);
		applicantPanel.setLayout(null);
		lblFirstNameApp.setBounds(10, 41, 73, 14);
		
		applicantPanel.add(lblFirstNameApp);
		
		applicantPanel.add(fNameAppTF);
		lblLastName.setBounds(10, 69, 73, 14);
		
		applicantPanel.add(lblLastName);
		
		applicantPanel.add(lNameTF);
		lblAddress.setBounds(10, 97, 73, 14);
		
		applicantPanel.add(lblAddress);
		
		applicantPanel.add(addressTF);
		lblPostalCode.setBounds(10, 123, 73, 14);
		
		applicantPanel.add(lblPostalCode);
		
		postMask.setPlaceholderCharacter('#');
		postMask.install(postCodeFTF);
		applicantPanel.add(postCodeFTF);
		lblPhoneNumber.setBounds(10, 179, 99, 14);
		
		applicantPanel.add(lblPhoneNumber);
		
		phoneMask.setPlaceholderCharacter('0');
		phoneMask.install(phoneNumFTF);
		applicantPanel.add(phoneNumFTF);
		lblEmail.setBounds(10, 204, 46, 14);
		
		applicantPanel.add(lblEmail);
		
		applicantPanel.add(emailTF);
		lblOfAdults.setBounds(10, 229, 73, 14);
		
		applicantPanel.add(lblOfAdults);
		lblOfChildren.setBounds(10, 254, 108, 14);
		
		applicantPanel.add(lblOfChildren);
		lblOfChildren_1.setBounds(10, 279, 108, 14);
		
		applicantPanel.add(lblOfChildren_1);
		lblCity.setBounds(10, 148, 46, 14);
		
		applicantPanel.add(lblCity);
		cityCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				do_cityCB_itemStateChanged(e);
			}
		});
		
		cityCB.setToolTipText("Pick or Enter the City you live in");
		cityCB.setModel(new DefaultComboBoxModel(new String[] {"", "Newmarket", "Queensville", "Mount Albert", "Holland Landing", "East Gwillimbury", "Aurora", "Sharon", "Schomberg", "Bradford", "Georgina/Keswick", "Markham", "Stouffville", "Richmond Hill", "Vaughan"}));
		cityCB.setEditable(true);
		cityCB.setBounds(119, 145, 143, 20);
		
		applicantPanel.add(cityCB);
		applicantPanel.setFocusCycleRoot(true);
		AdultSpinner.setToolTipText("Enter the number of adults in your family");
		AdultSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		AdultSpinner.setBounds(119, 226, 39, 20);
		
		applicantPanel.add(AdultSpinner);
		oldChildrenSpinner.setToolTipText("Enter the number of children 18 or older in your family");
		oldChildrenSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		oldChildrenSpinner.setBounds(119, 251, 39, 20);
		
		applicantPanel.add(oldChildrenSpinner);
		youngChildrenSpinner.setToolTipText("Enter the number of children 17 or younger");
		youngChildrenSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		youngChildrenSpinner.setBounds(119, 276, 39, 20);
		
		applicantPanel.add(youngChildrenSpinner);
		applicantPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{fNameAppTF, lNameTF, addressTF, postCodeFTF, cityCB, phoneNumFTF, emailTF, AdultSpinner, oldChildrenSpinner, youngChildrenSpinner}));
		
		tabbedPane.addTab("Child Info", null, childPanel, null);
		childPanel.setLayout(null);
		lblFirstNameChild.setBounds(10, 103, 71, 14);
		
		childPanel.add(lblFirstNameChild);
		
		childPanel.add(fNameChildTF);
		lblGender.setBounds(10, 132, 71, 14);
		
		childPanel.add(lblGender);
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setToolTipText("Click on your child's gender");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnMale_actionPerformed(e);
			}
		});
		rdbtnMale.setBounds(95, 128, 86, 23);
		
		childPanel.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setToolTipText("Click on your child's gender");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnFemale_actionPerformed(e);
			}
		});
		rdbtnFemale.setBounds(95, 154, 86, 23);
		
		childPanel.add(rdbtnFemale);
		lblBirthdate.setBounds(10, 187, 65, 14);
		
		childPanel.add(lblBirthdate);
		birthFTF.setToolTipText("Enter your child's birthday in the format MM/DD/YY");
		birthFTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_birthFTF_focusLost(arg0);
			}
		});
		birthFTF.setBounds(95, 184, 86, 20);
		birthMask.setPlaceholder(dateFormat.format(Calendar.getInstance().getTime()));
		birthMask.install(birthFTF);
		//birthFTF.setValue(dateFormat.format(Calendar.getInstance().getTime()));TODO
		
		childPanel.add(birthFTF);
		
		clothingCB.setToolTipText("Pick or enter your child's clothing size");
		clothingCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_clothingCB_actionPerformed(e);
			}
		});
		clothingCB.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		clothingCB.setEditable(true);
		clothingCB.setBounds(95, 243, 46, 20);
		
		childPanel.add(clothingCB);
		lblClothingSize.setBounds(10, 246, 85, 14);
		
		childPanel.add(lblClothingSize);
		lblShoeSize.setBounds(10, 277, 75, 14);
		
		childPanel.add(lblShoeSize);
		
		childPanel.add(shoeTF);
		lblCoatSize.setBounds(10, 303, 75, 14);
		
		childPanel.add(lblCoatSize);
		
		childPanel.add(coatTF);
		lblGameSystems.setBounds(257, 103, 95, 14);
		
		childPanel.add(lblGameSystems);
		scrollPane.setBounds(362, 210, 100, 93);
		
		childPanel.add(scrollPane);
		interestList.setToolTipText("Select any interest your child has");
		interestList.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_interestList_focusLost(e);
			}
		});
		scrollPane.setViewportView(interestList);
		interestList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Arts/Crafts", "Drawing", "Action Heroes", "Cars/Trucks", "Planes/Trains", "Music", "Construction", "Lego/Duplo", "Outdoors", "Dolls", "Sports"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lblInterests.setBounds(257, 212, 75, 14);
		
		childPanel.add(lblInterests);
		
		childPanel.add(interestTF);
		lblOtherinterests.setBounds(257, 313, 95, 14);
		
		childPanel.add(lblOtherinterests);
		lblChild.setBounds(10, 46, 46, 14);
		
		childPanel.add(lblChild);
		childCB.setToolTipText("Select a child to enter their infomation");
		childCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				do_childCB_itemStateChanged(e);
			}
		});
		childCB.setModel(new DefaultComboBoxModel(new String[] {"Child 1 - "}));
		childCB.setBounds(95, 43, 132, 20);
		
		childPanel.add(childCB);
		btnNewChild.setToolTipText("Create a new child to fill out infomation for");
		btnNewChild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNewChild_actionPerformed(arg0);
			}
		});
		btnNewChild.setBounds(112, 356, 115, 23);
		
		childPanel.add(btnNewChild);
		btnRemoveChild.setToolTipText("Remove the current child from the form");
		btnRemoveChild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRemoveChild_actionPerformed(e);
			}
		});
		btnRemoveChild.setBounds(237, 356, 115, 23);
		
		childPanel.add(btnRemoveChild);
		
		scrollPane_1.setBounds(362, 103, 100, 96);
		
		childPanel.add(scrollPane_1);
		gameList.setToolTipText("Select each game system your child owns");
		gameList.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_gameList_focusLost(arg0);
			}
		});
		gameList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Xbox 360", "Xbox 1", "Computer", "PS3", "PS4", "PSP", "Wii", "WiiU", "Nintendo DS"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(gameList);
		childPanel.setFocusCycleRoot(true);
		childPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{childCB, fNameChildTF, rdbtnMale, rdbtnFemale, birthFTF, clothingCB, shoeTF, coatTF, gameList, interestList, interestTF, btnNewChild, btnRemoveChild}));
		
		tabbedPane.addTab("Financial Info", null, financialPanel, null);
		financialPanel.setLayout(null);
		lblEmployment.setBounds(10, 48, 125, 14);
		
		financialPanel.add(lblEmployment);
		lblChildspousalSupport.setBounds(10, 73, 136, 14);
		
		financialPanel.add(lblChildspousalSupport);
		lblOntarioWorks.setBounds(10, 98, 125, 14);
		
		financialPanel.add(lblOntarioWorks);
		lblEiOrDisability.setBounds(10, 123, 125, 14);
		
		financialPanel.add(lblEiOrDisability);
		lblPensionIncome.setBounds(10, 148, 125, 14);
		
		financialPanel.add(lblPensionIncome);
		lblChildTaxCredits.setBounds(10, 173, 125, 14);
		
		financialPanel.add(lblChildTaxCredits);
		supportFTF.setToolTipText("Enter the amount of income your recieve from others in your family");
		
		supportFTF.setValue(0);
		supportFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_supportFTF_propertyChange(evt);
			}
		});
		supportFTF.setBounds(145, 70, 86, 20);
		supportFTF.setColumns(10);
		financialPanel.add(supportFTF);
		empFTF.setToolTipText("Enter the amount of income your recieve from your job");
		
		empFTF.setValue(0);
		empFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_empFTF_propertyChange(evt);
			}
		});
		empFTF.setBounds(145, 45, 86, 20);
		empFTF.setColumns(10);
		financialPanel.add(empFTF);
		worksFTF.setToolTipText("Enter the amount of income your recieve from Ontario Works");
		
		worksFTF.setValue(0);
		worksFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_worksFTF_propertyChange(evt);
			}
		});
		worksFTF.setBounds(145, 95, 86, 20);
		worksFTF.setColumns(10);
		financialPanel.add(worksFTF);
		eiFTF.setToolTipText("Enter the amount of income your recieve from E.I. or Disabilty benefits");
		
		eiFTF.setValue(0);
		eiFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_eiFTF_propertyChange(evt);
			}
		});
		eiFTF.setBounds(145, 120, 86, 20);
		eiFTF.setColumns(10);
		financialPanel.add(eiFTF);
		pensionFTF.setToolTipText("Enter the amount of income your recieve from pensions");
		
		pensionFTF.setValue(0);
		pensionFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_pensionFTF_propertyChange(evt);
			}
		});
		pensionFTF.setBounds(145, 145, 86, 20);
		pensionFTF.setColumns(10);
		financialPanel.add(pensionFTF);
		creditsFTF.setToolTipText("Enter the amount of income your recieve from child tax credits");
		
		creditsFTF.setValue(0);
		creditsFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_creditsFTF_propertyChange(evt);
			}
		});
		creditsFTF.setBounds(145, 170, 86, 20);
		creditsFTF.setColumns(10);
		financialPanel.add(creditsFTF);
		lblGasHydro.setBounds(265, 73, 76, 14);
		
		financialPanel.add(lblGasHydro);
		gasFTF.setToolTipText("Enter the amount you pay for gas and water utility");
		
		gasFTF.setValue(0);
		gasFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_gasFTF_propertyChange(evt);
			}
		});
		gasFTF.setBounds(415, 70, 86, 20);
		gasFTF.setColumns(10);
		financialPanel.add(gasFTF);
		lblPhoneTv.setBounds(265, 98, 76, 14);
		
		financialPanel.add(lblPhoneTv);
		phoneFTF.setToolTipText("Enter the amount you pay for phone and tv service");
		
		phoneFTF.setValue(0);
		phoneFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_phoneFTF_propertyChange(evt);
			}
		});
		phoneFTF.setBounds(415, 95, 86, 20);
		phoneFTF.setColumns(10);
		financialPanel.add(phoneFTF);
		lblChildCare.setBounds(265, 123, 76, 14);
		
		financialPanel.add(lblChildCare);
		childCareFTF.setToolTipText("Enter the amount you pay for child care");
		
		childCareFTF.setValue(0);
		childCareFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_childCareFTF_propertyChange(evt);
			}
		});
		childCareFTF.setBounds(415, 120, 86, 20);
		childCareFTF.setColumns(10);
		financialPanel.add(childCareFTF);
		lblLoansInsurance.setBounds(265, 173, 140, 14);
		
		financialPanel.add(lblLoansInsurance);
		loansFTF.setToolTipText("Enter the amount you pay for loans and insurance");
		
		loansFTF.setValue(0);
		loansFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_loansFTF_propertyChange(evt);
			}
		});
		loansFTF.setBounds(415, 170, 86, 20);
		loansFTF.setColumns(10);
		financialPanel.add(loansFTF);
		transitGasFTF.setToolTipText("Enter the amount you pay for transit and gas");
		
		transitGasFTF.setValue(0);
		transitGasFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_transitGasFTF_propertyChange(evt);
			}
		});
		transitGasFTF.setBounds(415, 145, 86, 20);
		transitGasFTF.setColumns(10);
		financialPanel.add(transitGasFTF);
		rentMortgageFTF.setToolTipText("Enter the amount you pay for your rent and mortgage");

		rentMortgageFTF.setValue(0);
		rentMortgageFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_rentMortgageFTF_propertyChange(evt);
			}
		});
		rentMortgageFTF.setBounds(415, 45, 86, 20);
		rentMortgageFTF.setColumns(10);
		financialPanel.add(rentMortgageFTF);
		chckbxRent.setToolTipText("Click if you pay rent");
 
		chckbxRent.setBounds(265, 44, 56, 23);
		
		financialPanel.add(chckbxRent);
		chckbxMortgage.setToolTipText("Click if you pay a mortgage");
		chckbxMortgage.setBounds(323, 44, 86, 23);
		
		financialPanel.add(chckbxMortgage);
		chckbxTransit.setToolTipText("Click if you pay for public transit");
		chckbxTransit.setBounds(265, 144, 76, 23);
		
		financialPanel.add(chckbxTransit);
		chckbxGas.setToolTipText("Click if you pay for gas for your car");
		chckbxGas.setBounds(343, 144, 64, 23);
		
		financialPanel.add(chckbxGas);
		lblIncome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIncome.setBounds(93, 11, 76, 23);
		
		financialPanel.add(lblIncome);
		lblExpenses.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExpenses.setBounds(363, 11, 76, 23);
		
		financialPanel.add(lblExpenses);
		lblTotalIncome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalIncome.setBounds(58, 214, 173, 14);
		
		financialPanel.add(lblTotalIncome);
		lblTotalExpenses.setForeground(Color.red);
		lblTotalExpenses.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalExpenses.setBounds(323, 214, 178, 14);
		
		financialPanel.add(lblTotalExpenses);
		lblNetIncome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNetIncome.setBounds(155, 271, 284, 14);
		
		financialPanel.add(lblNetIncome);
		financialPanel.setFocusCycleRoot(true);
		financialPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{empFTF, supportFTF, worksFTF, eiFTF, pensionFTF, creditsFTF, rentMortgageFTF, gasFTF, phoneFTF, childCareFTF, transitGasFTF, loansFTF}));
		
		children.add(new Child());
	}

	protected void do_tabbedPane_stateChanged(ChangeEvent arg0) {//Checks to make sure all required fields in the current tab are filled out
		boolean requiredEmpty = false;
		boolean focusGrabbed = false;
		if(tabbedPane.getSelectedIndex() != currentTabIndex && currentTabIndex == 0) {

			if(fNameAppTF.getText().isEmpty()){
				tabbedPane.setSelectedIndex(0);
				lblFirstNameApp.setForeground(Color.red);
				requiredEmpty = true;
				fNameAppTF.grabFocus();
				focusGrabbed = true;
			}
			if(lNameTF.getText().isEmpty()){
				tabbedPane.setSelectedIndex(0);
				lblLastName.setForeground(Color.red);
				requiredEmpty = true;
				if(!focusGrabbed){
					focusGrabbed = true;
				lNameTF.grabFocus();
				}
			}
			if(addressTF.getText().isEmpty()){
				tabbedPane.setSelectedIndex(0);
				lblAddress.setForeground(Color.red);
				requiredEmpty = true;
				if(!focusGrabbed){
					focusGrabbed = true;
					addressTF.grabFocus();
				}
			}
			if(postCodeFTF.getText().equals("#####")){
				tabbedPane.setSelectedIndex(0);
				lblPostalCode.setForeground(Color.red);
				requiredEmpty = true;
				if(!focusGrabbed){
					focusGrabbed = true;
					postCodeFTF.grabFocus();
				}
			}
			if(cityCB.getSelectedItem().toString().isEmpty()){
				tabbedPane.setSelectedIndex(0);
				lblCity.setForeground(Color.red);
				requiredEmpty = true;
				if(!focusGrabbed){
					focusGrabbed = true;
					cityCB.grabFocus();
				}
			}
			if(phoneNumFTF.getText().equals("(000)000-0000")){
				tabbedPane.setSelectedIndex(0);
				lblPhoneNumber.setForeground(Color.red);
				requiredEmpty = true;
				if(!focusGrabbed){
					focusGrabbed = true;
				phoneNumFTF.grabFocus();
				}
			}
			if(emailTF.getText().isEmpty()) {
				tabbedPane.setSelectedIndex(0);
				lblEmail.setForeground(Color.red);
				requiredEmpty = true;
				if(!focusGrabbed){
					focusGrabbed = true;
					emailTF.grabFocus();
				}
			}
		}
		else if(tabbedPane.getSelectedIndex() != currentTabIndex && currentTabIndex == 1)
			requiredEmpty = !validateChild();
		
		
		if(requiredEmpty)
			JOptionPane.showMessageDialog(this, "Please fill out all required fields in the tab before moving on", "Missing Required Fields Error", JOptionPane.ERROR_MESSAGE);
		
		
		currentTabIndex = tabbedPane.getSelectedIndex();
	}
	private boolean validateChild() { //check to make sure all the required fields for a child is filled out
		boolean valid = true;
		updateChild();
		if(dateFormat.format(children.get(currentChildNum).birthDate).equals(dateFormat.format(Calendar.getInstance().getTime()))){
			tabbedPane.setSelectedIndex(1);
			childCB.setSelectedIndex(currentChildNum);
			lblBirthdate.setForeground(Color.red);
			birthFTF.grabFocus();
			valid = false;
		}
		if(children.get(currentChildNum).gender != 'M' && children.get(currentChildNum).gender != 'F') {
			tabbedPane.setSelectedIndex(1);
			childCB.setSelectedIndex(currentChildNum);
			lblGender.setForeground(Color.red);
			rdbtnMale.grabFocus();
			valid = false;
		}
		if(children.get(currentChildNum).firstName.isEmpty()){
			tabbedPane.setSelectedIndex(1);
			childCB.setSelectedIndex(currentChildNum);
			lblFirstNameChild.setForeground(Color.red);
			fNameChildTF.grabFocus();
			valid = false;
		}
		return valid;
	}
	protected void do_btnNewChild_actionPerformed(ActionEvent arg0) {//creates a new child, adds it to childCB, and make it the selected item
		if(validateChild()){
			children.add(new Child());
			updateChildCB();
			childCB.setSelectedIndex(Child.childNum-1);
		}
		else
			JOptionPane.showMessageDialog(this, "Please complete all required field before creating a new child", "Empty Required Fields Error", JOptionPane.ERROR_MESSAGE);
	}
	protected void do_btnRemoveChild_actionPerformed(ActionEvent e) {//removes current child and makes sure all children with a greater id are updated to a new correct id
		if(Child.childNum>1) {
			int childIndex = findChildIndex();
			children.remove(childIndex);
			Child.childNum--;
			for(int i = childIndex; i < children.size(); i++)
				children.get(i).cid--;
			updateChildCB();
			do_childCB_itemStateChanged(null);
		}
		else
			JOptionPane.showMessageDialog(this, "You need to fill out the form for at least one Child.", "One Child Left Error", JOptionPane.ERROR_MESSAGE);
	}
	private void updateChildCB() {//updates the model on childCB to make it dynamic and current
		String[] model = new String[Child.childNum];
		for(int i = 0; i < children.size(); i++)
			model[i] = "Child " + children.get(i).cid + " - " + children.get(i).firstName; 
		
		childCB.setModel(new DefaultComboBoxModel(model));
	}
	private void updateChild() {//updates the fields in the child panel to the current child's appropriate values
		fNameChildTF.setText(findChild().firstName);
		
		if(findChild().gender == 'M')
			rdbtnMale.setSelected(true);
		else if(findChild().gender == 'F') 
			rdbtnFemale.setSelected(true);
		else 
			buttonGroup.clearSelection();
		
		birthMask.setPlaceholder(dateFormat.format(findChild().birthDate));
		birthMask.install(birthFTF);
		shoeTF.setText(findChild().shoeSize);
		coatTF.setText(findChild().coatSize);
		interestTF.setText(findChild().otherInterests);
		gameList.setSelectedIndices(findIndices(findChild().gameSystems, gameList));
		interestList.setSelectedIndices(findIndices(findChild().interests, interestList));
		clothingCB.setSelectedItem(findChild().clothingSize);
	}
	protected void do_childCB_itemStateChanged(ItemEvent e) {//validates and updates child panel when a different child is selected
		if(currentChildNum == findChildIndex()||validateChild()){
			currentChildNum = findChildIndex();
			updateChild();
		}
		else{
			JOptionPane.showMessageDialog(this, "Please complete all required field before changing children", "Empty Required Fields Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private int[] findIndices (Object[] array, JList list){//compares an array to a JList in order to identifies which indexes the elements of the array can be found in the JList
		int[] indices = new int[array.length];
		int index = 0;
		for(int i = 0; i<list.getModel().getSize(); i++) 
			for(Object elem : array)
				if(elem.equals(list.getModel().getElementAt(i)))
					indices[index++] = i;
		return indices;
	}
	protected void do_fNameChildTF_focusLost(FocusEvent arg0) { //updates the current child's first name(and childCB) when focus is lost in fNameChildTF
		findChild().firstName = fNameChildTF.getText();
		int childIndex = findChildIndex();
		updateChildCB();
		childCB.setSelectedIndex(childIndex);
		if(!fNameChildTF.getText().isEmpty())
			lblFirstNameChild.setForeground(Color.black);
	}
	private int findChildIndex() {//finds index of the current child selected in childCB
		return Integer.parseInt(childCB.getSelectedItem().toString().split(" ")[1])-1;
	}
	private Child findChild() {//returns the current child
		return children.get(findChildIndex());
	}
	protected void do_rdbtnMale_actionPerformed(ActionEvent e) {//updates the child's gender to M when rdbtnMale is clicked
		findChild().gender = 'M';
		lblGender.setForeground(Color.black);
	}
	protected void do_rdbtnFemale_actionPerformed(ActionEvent e) {//updates the child's gender to F when rdbtnFemale is clicked
		findChild().gender = 'F';
		lblGender.setForeground(Color.black);
	}
	protected void do_birthFTF_focusLost(FocusEvent arg0) {//updates the child's birthdate when birthFTF loses focus. Also makes sure a valid age was entered
		try {
			findChild().birthDate = dateFormat.parse(birthFTF.getText());
			int age = calculateAge(findChild().birthDate);
			if(age<0) {
				JOptionPane.showMessageDialog(this, "Please Enter a Possible Age", "Negative Age Error", JOptionPane.ERROR_MESSAGE);
				birthFTF.grabFocus();
			}
			else if(age>=18) {
				JOptionPane.showMessageDialog(this, "Please only enter children that are younger than 18 years old", "Old Child Error", JOptionPane.ERROR_MESSAGE);
				birthFTF.grabFocus();
			}
			else
				findChild().age = age;

			if(!birthFTF.getText().equals(dateFormat.format(Calendar.getInstance().getTime())))
				lblBirthdate.setForeground(Color.black);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Please Enter a Valid Date", "Invalid Date Error", JOptionPane.ERROR_MESSAGE);
			birthFTF.grabFocus();
		}
	}
	private int calculateAge(Date birthdate){ //calculates age based on birthdate
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthdate);
		int age = now.get(Calendar.YEAR)-birth.get(Calendar.YEAR);
		if(now.get(Calendar.MONTH) < birth.get(Calendar.MONTH))
			age--;
		else if(now.get(Calendar.MONTH) == birth.get(Calendar.MONTH) && now.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH))
			age--;
		return age;
	}
		
	protected void do_clothingCB_actionPerformed(ActionEvent e) {//updates child's clothing size when clothingCB loses focus
		findChild().clothingSize = clothingCB.getSelectedItem().toString();
	}
	protected void do_shoeTF_focusLost(FocusEvent e) {//updates child's shoe size when showTF loses focus
		findChild().shoeSize = shoeTF.getText();
	}
	protected void do_coatTF_focusLost(FocusEvent e) {//updates child's coat size when coatTF loses focus
		findChild().coatSize = coatTF.getText();
	}
	protected void do_gameList_focusLost(FocusEvent arg0) { //updates child's game systems when gameList loses focus
		findChild().gameSystems = gameList.getSelectedValuesList().toArray();
	}
	protected void do_interestList_focusLost(FocusEvent e) {//updates child's interests when interestList loses focus
		findChild().interests = interestList.getSelectedValuesList().toArray();
	}
	protected void do_interestTF_focusLost(FocusEvent e) {//updates child's other interests when interestTF loses focus
		findChild().otherInterests = interestTF.getText();
	}
	protected void do_empFTF_propertyChange(PropertyChangeEvent evt) {//all these functions update net income when the property of one of the text fields in the financial panel changes
		calcNetIncome();
	}
	protected void do_supportFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_worksFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_eiFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_pensionFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_creditsFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_rentMortgageFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_gasFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_phoneFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_childCareFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_transitGasFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	protected void do_loansFTF_propertyChange(PropertyChangeEvent evt) {
		calcNetIncome();
	}
	private void calcNetIncome() {//calculates and updates net income
		double netIncome = calcIncome() - calcExpenses();
		if(netIncome>=0){
			lblNetIncome.setText("Net Income: $" + netIncome);
			lblNetIncome.setForeground(Color.black);
		}
		else{
			lblNetIncome.setText("Net Income: -$" + (-1*netIncome));
			lblNetIncome.setForeground(Color.red);
		}
	}
	private double calcIncome() {//calculates and updates total income
		double income = ((Number) empFTF.getValue()).doubleValue() + ((Number) supportFTF.getValue()).doubleValue() + ((Number) worksFTF.getValue()).doubleValue() + ((Number) eiFTF.getValue()).doubleValue() + ((Number) pensionFTF.getValue()).doubleValue() + ((Number) creditsFTF.getValue()).doubleValue();
		lblTotalIncome.setText("Total Income: $" + income);
		return income;
	}
	private double calcExpenses() {//calculates and updates total expenses
		double expenses = ((Number) rentMortgageFTF.getValue()).doubleValue() + ((Number) gasFTF.getValue()).doubleValue() + ((Number) phoneFTF.getValue()).doubleValue() + ((Number) childCareFTF.getValue()).doubleValue() + ((Number) transitGasFTF.getValue()).doubleValue() + ((Number) loansFTF.getValue()).doubleValue();
		lblTotalExpenses.setText("Total Expenses: $" + expenses);
		return expenses;
	}
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {//closes frame
		this.dispose();
	}
	protected void do_mntmStartNewForm_actionPerformed(ActionEvent e) {//creates new frame and disposes old frame
		this.main(new String[0]);
		this.dispose();
	}
	protected void do_mntmApplicantInfoHelp_actionPerformed(ActionEvent e) { //displays help for applicant info
		JOptionPane.showMessageDialog(this, "<html><h3>Application Info Help:</h3>"+
				"<p><u>First Name:</u> Enter your first name into the corresponding textbox</p><br>"+
				"<p><u>Last Name:</u> Enter your last name into the corresponding textbox</p><br>"+
				"<p><u>Address:</u> Enter your address into the corresponding textbox</p><br>"+
				"<p><u>Postal Code:</u> Enter your postal code into the corresponding textbox</p><br>"+
				"<p><u>City:</u> Pick or Enter the City you live in into the corresponding drop down menu</p><br>"+
				"<p><u>Phone Number:</u> Enter your phone number into the corresponding textbox</p><br>"+
				"<p><u>Email:</u> Enter your email into the corresponding textbox</p><br>"+
				"<p><u># of Adults:</u> Enter the number of adults in your family into the corresponding spinner</p><br>"+
				"<p><u># of Children 18+:</u> Enter the number of children 18 or older in your family into the corresponding spinner</p><br>"+
				"<p><u># of Children 0-17:</u> Enter the number of children 17 or younger in your family into the corresponding spinner</p></html>", "Application Info Help", JOptionPane.INFORMATION_MESSAGE);
	}
	protected void do_mntmChildInfoHelp_actionPerformed(ActionEvent e) {//displays help for applicant info
		JOptionPane.showMessageDialog(this, "<html><h3>Child Info Help:</h3>"+
				"<p><u>Child:</u> Select a child from the corresponding drop down menu to enter their infomation</p><br>"+
				"<p><u>First Name:</u> Enter the child's first name into the corresponding textbox</p><br>"+
				"<p><u>Gender:</u> Click on the radio button corresponding your child's gender</p><br>"+
				"<p><u>Birthdate:</u> Enter your child's birthday in the format MM/DD/YY into the corresponding textbox</p><br>"+
				"<p><u>Age:</u> Enter your child's age into the corresponding textbox</p><br>"+
				"<p><u>Clothing Size</u> Pick or enter your child's clothing size into the corresponding drop down menu</p><br>"+
				"<p><u>Shoe Size:</u> Enter your child's shoe size into the corresponding textbox</p><br>"+
				"<p><u>Coat Size:</u> Enter your child's coat size into the corresponding textbox</p><br>"+
				"<p><u>Game Systems:</u> Select each game system your child owns from the corresponding list</p><br>"+
				"<p><u>Interests:</u> Select any interest your child has from the corresponding list</p><br>"+
				"<p><u>Other Interests:</u> Enter any other interests your child has that aren't listed above into the corresponding textbox</p><br>"+
				"<p><u>New Child:</u> Click this button to create a new child to fill out infomation for</p><br>"+
				"<p><u>Remove Child:</u> Click this button to remove the current child from the form</p></html>", "Child Info Help", JOptionPane.INFORMATION_MESSAGE);
	}
	protected void do_mntmFinacialInfoHelp_actionPerformed(ActionEvent e) {//displays help for applicant info
		JOptionPane.showMessageDialog(this, "<html><h3>Financial Info Help:</h3>"+
				"<p><u>Employment:</u> Enter the amount of income your recieve from your job into the corresponding textbox</p><br>"+
				"<p><u>Child/Spousal Support:</u> Enter the amount of income your recieve from others in your family into the corresponding textbox</p><br>"+
				"<p><u>Ontario Works</u> Enter the amount of income your recieve from Ontario Works into the corresponding textbox</p><br>"+
				"<p><u>E.I. or Disabilty:</u> Enter the amount of income your recieve from E.I. or Disabilty benefits into the corresponding textbox</p><br>"+
				"<p><u>Pension Income:</u> Enter the amount of income your recieve from pensions into the corresponding textbox</p><br>"+
				"<p><u>Child Tax Credits:</u> Enter the amount of income your recieve from child tax credits into the corresponding textbox</p><br>"+
				"<p><u>Rent/Mortgage:</u> Click the rent checkbox if you pay rent<br>"+
				"Click the mortgage checkbox if you pay a mortgage<br>"+
				"Enter the amount you pay for your rent and mortgage into the corresponding textbox</p><br>"+
				"<p><u>Gas + Hydro</u> Enter the amount you pay for gas and water utility into the corresponding textbox</p><br>"+
				"<p><u>Phone + TV:</u> Enter the amount you pay for phone and tv service into the corresponding textbox</p><br>"+
				"<p><u>Child Care:</u> Enter the amount you pay for child care into the corresponding textbox</p><br>"+
				"<p><u>Transit/Gas:</u> Click the transit checkbox if you pay for public transit<br>"+
				"Click the gas checkbox if you pay for gas for your car<br>"+
				"Enter the amount you pay for transit and gas into the corresponding textbox</p><br>"+
				"<p><u>Loans + Insurance</u> Enter the amount you pay for loans and insurance into the corresponding textbox</p></html>", "Financial Info Help", JOptionPane.INFORMATION_MESSAGE);
	}
	protected void do_fNameAppTF_focusLost(FocusEvent e) {//the following function changes the applicant panel's required fields' corresponding labels' color to black (meant for after they turn red when user fail to fill them out)
		if(!fNameAppTF.getText().isEmpty())
			lblFirstNameApp.setForeground(Color.black);
	}
	protected void do_lNameTF_focusLost(FocusEvent e) {
		if(!lNameTF.getText().isEmpty())
			lblLastName.setForeground(Color.black);
	}
	protected void do_addressTF_focusLost(FocusEvent e) {
		if(!addressTF.getText().isEmpty())
			lblAddress.setForeground(Color.black);
	}
	protected void do_postCodeFTF_focusLost(FocusEvent e) {
		if(postCodeFTF.getText().contains("#"))
			JOptionPane.showMessageDialog(this, "Please Enter a valid Postal Code", "Invalid Postal Code Error", JOptionPane.ERROR_MESSAGE);
		else
			lblPostalCode.setForeground(Color.black);
	}
	protected void do_phoneNumFTF_focusLost(FocusEvent e) {
		if(!phoneNumFTF.getText().equals("(000)000-0000"))
			lblPhoneNumber.setForeground(Color.black);
	}
	protected void do_emailTF_focusLost(FocusEvent e) {
		if(!emailTF.getText().isEmpty())
			lblEmail.setForeground(Color.black);
	}
	protected void do_cityCB_itemStateChanged(ItemEvent e) {
		if(!cityCB.getSelectedItem().toString().isEmpty())
			lblCity.setForeground(Color.black);
	}
}

class Child { //Child child to help record data about children and make the child panel more dynamic 
	String firstName= "";
	char gender;
	Date birthDate = Calendar.getInstance().getTime();
	int age;
	String clothingSize = "XS";
	String shoeSize = "";
	String coatSize = "";
	Object[] gameSystems = {};
	Object[] interests = {};
	String otherInterests = "";
	static int childNum;
	int cid;
	
	Child() {
		cid = ++childNum;
	}
}
