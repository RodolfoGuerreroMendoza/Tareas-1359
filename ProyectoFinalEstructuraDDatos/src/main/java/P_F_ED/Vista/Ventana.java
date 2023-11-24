package P_F_ED.Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JLabel lblName;
    private JLabel lblPhone;
    private JLabel lblEmail;
    private JLabel lblId;
    private JLabel lblGhost;
    private JLabel lblSearch;
    private JTextField txtName;
    private JTextField txtphone;
    private JTextField txtEmail;
    private JTextField txtId;
    private JTextField txtSearch;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private  JButton btnCargar;
    private JButton btnSearch;
    private JTable tblDirectorio;
    private JScrollPane scrollPane;
    private JPanel panel1;
    private JPanel panel2;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException{
        super(title);
        this.setSize(1000, 550);
        layout = new GridLayout(1,2);
        this.getContentPane().setLayout(layout);

        // Panel 1(Formulario)
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(255, 255, 255));
        lblName = new JLabel("Nombre: ");
        lblPhone = new JLabel("Celular: ");
        lblId = new JLabel("Id: ");
        lblEmail = new JLabel("Email: ");
        lblSearch = new JLabel("Buscar: ");
        txtId = new JTextField(2);
        btnSearch = new JButton("Buscar");
        lblGhost = new JLabel("                                                                                                                                                                                                                                                                                                                       ");
        txtId.setText("0");
        txtId.setEnabled(false);
        txtName = new JTextField(35);
        txtphone = new JTextField(10);
        txtEmail = new JTextField(20);
        txtSearch = new JTextField(5);
        btnAgregar = new JButton("Agregar");

        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblName);
        panel1.add(txtName);
        panel1.add(lblPhone);
        panel1.add(txtphone);
        panel1.add(lblEmail);
        panel1.add(txtEmail);

        panel1.add(btnAgregar);

        panel1.add(lblGhost);
        panel1.add(lblSearch);
        panel1.add(txtSearch);
        panel1.add(btnSearch);

        // Panel 2 (Tabla y btnEliminar)
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(255, 255, 255));

        btnEliminar = new JButton("Borrar");
        btnCargar = new JButton("Cargar");
        tblDirectorio = new JTable();
        scrollPane = new JScrollPane(tblDirectorio);
        panel2.add(scrollPane);
        panel2.add(btnCargar);
        panel2.add(btnEliminar);


        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2, 1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblName() {
        return lblName;
    }

    public void setLblName(JLabel lblName) {
        this.lblName = lblName;
    }

    public JLabel getLblPhone() {
        return lblPhone;
    }

    public void setLblPhone(JLabel lblPhone) {
        this.lblPhone = lblPhone;
    }

    public JLabel getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(JLabel lblEmail) {
        this.lblEmail = lblEmail;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtphone() {
        return txtphone;
    }

    public void setTxtphone(JTextField txtphone) {
        this.txtphone = txtphone;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTblDirectorio() {
        return tblDirectorio;
    }

    public void setTblDirectorio(JTable tblDirectorio) {
        this.tblDirectorio = tblDirectorio;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JLabel getLblGhost() {
        return lblGhost;
    }

    public void setLblGhost(JLabel lblGhost) {
        this.lblGhost = lblGhost;
    }

    public JLabel getLblSearch() {
        return lblSearch;
    }

    public void setLblSearch(JLabel lblSearch) {
        this.lblSearch = lblSearch;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public void limpiarEntradas(){
        txtName.setText("");
        txtphone.setText("");
        txtEmail.setText("");
    }
}
