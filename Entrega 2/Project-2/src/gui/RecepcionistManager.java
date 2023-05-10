package gui;

import core.*;
import utils.DateRange;
import utils.Utils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

public class RecepcionistManager extends JPanel implements ActionListener, MouseMotionListener {
    private GUI _gui;
    private JLabel servicesLabel;
    private JLabel roomsLabel;
    private final JButton checkin = new JButton("1. Check-in");
    private final JButton checkroom = new JButton("2. Check rooms");
    private final JButton bill = new JButton("Print bill and checkout");
    private JButton end = new JButton("End adding");
    private JButton add = new JButton("Add member");
    private JFrame f = new JFrame();
    private JDialog d = new JDialog(f, "Hotel DPOO | Guests", true);
    private JFrame f2 = new JFrame();
    private JDialog groupRoomsManager = new JDialog(f2, "Hotel DPOO | Group Assignation", true);
    private JLabel name = new JLabel("Name");
    private JTextField namet = new JTextField();
    private JLabel mail = new JLabel("Mail");
    private JTextField mailt = new JTextField();
    private JLabel age = new JLabel("Age");
    private JTextField aget = new JTextField();
    private JLabel document = new JLabel("Identification Number");
    private JTextField documentt = new JTextField();
    private JLabel id = new JLabel("Name");
    private JTextField idt = new JTextField();

    private final JButton Logout = new JButton("Logout");
    private final JButton Help = new JButton("Help");
    private ArrayList<Guest> guests;

    private JFrame x = new JFrame();
    private JDialog y = new JDialog(x, "Hotel DPOO | Rooms", true);
    private JButton salir = new JButton("Finish");

    public void update() {
        //if (_gui.directory().restaurant()==null||_gui.directory().spa()==null||_gui.directory().tourGuide()==null)
        //{

        //setLayout(null);
        //setBounds(50, 250 , 900, 700);
        //servicesLabel1.setFont(new Font(servicesLabel1.getFont().getName(), Font.BOLD, 24));
        //servicesLabel1.setBounds(0, 150, 1000, 70);
        //add(servicesLabel1);
        //setLayout(null);
        //setBounds(0, 250 , 900, 700);
        //Logout.setBounds(0, 380, 450, 31);
        //Logout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        //Logout.addActionListener(this);
        //add(Logout);
        //}
        //else
        //{
        setLayout(null);
        setBounds(0, 250, 900, 700);


        servicesLabel = new JLabel("Services");
        servicesLabel.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
        servicesLabel.setBounds(200, 30, 600, 70);
        add(servicesLabel);

        checkin.setBackground(new Color(0x00ffe3));
        checkin.setBounds(100, 90, 300, 31);
        checkin.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        checkin.addActionListener(this);
        add(checkin);

        checkroom.setBackground(new Color(0x00ffe3));
        checkroom.setBounds(100, 120, 300, 31);
        checkroom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        add(checkroom);


        roomsLabel = new JLabel("Group");
        roomsLabel.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
        roomsLabel.setBounds(600, 30, 600, 70);
        add(roomsLabel);

        DefaultListModel<String> aa = new DefaultListModel<>();
        //
        HashMap<Long, Group> grupos1 = _gui.directory().groups();
        for (Map.Entry<Long, Group> entry : grupos1.entrySet()) {
            Long key = entry.getKey();
            Group value = entry.getValue();
            HashMap<Long, Guest> miembros = value.members();
            aa.addElement("Grupo con identificacion " + value.id());


            // do what you have to do here
            // In your case, another loop.
        }


        JList<String> grupos = new JList<String>(aa);
        grupos.setBounds(600, 30, 600, 70);


        JScrollPane scrollpane = new JScrollPane(grupos);
        scrollpane.setBounds(490, 90, 300, 200);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollpane);


        bill.setBackground(new Color(0x00ffe3));
        bill.setBounds(490, 300, 300, 31);
        bill.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        bill.addActionListener(this);
        add(bill);


        Logout.setBounds(0, 380, 450, 31);
        Logout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        Logout.addActionListener(this);
        add(Logout);

        Help.setBounds(450, 380, 450, 31);
        Help.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        add(Help);
        //}
    }

    public RecepcionistManager(GUI gui) {
        _gui = gui;
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == checkin) {
            guests = new ArrayList<>();
            d.setLayout(null);

            add.setBackground(new Color(0x00ffe3));
            add.setBounds(390, 200, 130, 31);
            add.addActionListener(this);

            end.setBackground(new Color(0x00ffe3));
            end.setBounds(520, 200, 130, 31);
            end.addActionListener(this);

            name.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            name.setBounds(10, 10, 300, 31);
            namet.setBounds(10, 50, 300, 31);

            mail.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            mail.setBounds(10, 90, 300, 31);
            mailt.setBounds(10, 130, 300, 31);

            age.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            age.setBounds(350, 10, 300, 31);
            aget.setBounds(350, 50, 300, 31);

            document.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            document.setBounds(350, 90, 300, 31);
            documentt.setBounds(350, 130, 300, 31);

            id.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            id.setBounds(10, 10, 300, 31);
            idt.setBounds(10, 50, 300, 31);

            checkroom.addActionListener(this);
            d.add(add);
            d.add(end);
            d.add(name);
            d.add(namet);
            d.add(mail);
            d.add(mailt);
            d.add(age);
            d.add(aget);
            d.add(document);
            d.add(documentt);
            d.add(id);
            d.add(idt);

            d.setSize(700, 300);
            d.setVisible(true);


        }

        if (event.getSource() == add) {
            ///
            ///
            ///
            ///
            ///
            guests.add(new Guest(namet.getText(), Integer.parseInt(aget.getText()), Long.parseLong(documentt.getText()), mailt.getText()));
            namet.setText("");
            mailt.setText("");
            aget.setText("");
            documentt.setText("");
        }

        if (event.getSource() == end) {
            Group group = new Group(guests.get(0), new ArrayList<>(guests));
            guests.clear();
            long group_id = group.id();
            _gui.directory().addGroup(group);
            d.setVisible(false);
            y.setLayout(null);

            JLabel date = new JLabel("Admission date DD-MM-AA (Only the number of year)");
            JTextField datet = new JTextField();
            date.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            date.setBounds(10, 40, 300, 31);
            datet.setBounds(10, 80, 300, 31);

            JLabel date2 = new JLabel("Departure date DD-MM-AA (Only the number of year)");
            JTextField date2t = new JTextField();
            date2.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            date2.setBounds(10, 120, 300, 31);
            date2t.setBounds(10, 160, 300, 31);


            JLabel type = new JLabel("Room type");
            type.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            type.setBounds(360, 40, 300, 31);
            ButtonGroup g = new ButtonGroup();
            JRadioButton btn1 = new JRadioButton("Standard");
            btn1.setBounds(360, 80, 100, 31);
            btn1.setSelected(true);
            JRadioButton btn2 = new JRadioButton("Suite");
            btn2.setBounds(360, 120, 100, 31);
            JRadioButton btn3 = new JRadioButton("Double Suite");
            btn3.setBounds(360, 160, 100, 31);


            JLabel addition = new JLabel("Addition");
            addition.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            addition.setBounds(550, 40, 300, 31);
            JCheckBox opc1 = new JCheckBox("Balcony");
            opc1.setBounds(550, 80, 300, 31);
            JCheckBox opc2 = new JCheckBox("View");
            opc2.setBounds(550, 120, 300, 31);
            JCheckBox opc3 = new JCheckBox("Built-in kitchen");
            opc3.setBounds(550, 160, 300, 31);


            salir.setBackground(new Color(0x00ffe3));
            salir.setBounds(530, 210, 130, 31);
            salir.addActionListener(
                    event_finish -> {
                        if (event_finish.getSource() == salir) {
                            this.update();
                            int index = 0;
                            DateRange dateRange = new DateRange(datet.getText(), date2t.getText());
                            while (index < _gui.directory().groups().get(group_id).members().values().size() - 1) {
                                for (Room room : _gui.directory().hotel().rooms().values()) {
                                    boolean canOccupied = true;
                                    for (DateRange dateRangeRoom : room.occupancyRanges()) {
                                        if (dateRangeRoom.inRange(dateRange)) {
                                            canOccupied = false;
                                            break;
                                        }
                                    }
                                    if (canOccupied) {
                                        if (btn1.isSelected() && room.type().equals("single")) {
                                            while (room.canAddOccupant() && index < _gui.directory().groups().get(group_id).members().values().size() - 1) {
                                                room.addOccupant((Guest) _gui.directory().groups().get(group_id).members().values().toArray()[index]);
                                                index++;
                                                if (index >= _gui.directory().groups().get(group_id).members().size())
                                                    break;
                                            }
                                        } else if (btn2.isSelected() && room.type().equals("suite")) {
                                            while (room.canAddOccupant() && index < _gui.directory().groups().get(group_id).members().values().size() - 1) {
                                                room.addOccupant((Guest) _gui.directory().groups().get(group_id).members().values().toArray()[index]);
                                                index++;
                                                if (index >= _gui.directory().groups().get(group_id).members().size())
                                                    break;
                                            }
                                        } else if (btn3.isSelected() && room.type().equals("double")) {
                                            while (room.canAddOccupant() && index < _gui.directory().groups().get(group_id).members().values().size() - 1) {
                                                room.addOccupant((Guest) _gui.directory().groups().get(group_id).members().values().toArray()[index]);
                                                index++;
                                                if (index >= _gui.directory().groups().get(group_id).members().size())
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                            y.setVisible(false);
                        }
                    }
            );


            g.add(btn1);
            g.add(btn2);
            g.add(btn3);


            y.add(type);
            y.add(addition);

            y.add(btn1);
            y.add(btn2);
            y.add(btn3);
            y.add(salir);
            y.add(opc1);
            y.add(opc2);
            y.add(opc3);

            y.add(date);
            y.add(datet);
            y.add(date2);
            y.add(date2t);

            y.setSize(700, 300);
            y.setVisible(true);
        }

        if (event.getSource() == Logout) {
            _gui.change("login");
        }
        if (event.getSource() == bill) {
            try {
                Long idg = Long.valueOf(JOptionPane.showInputDialog(_gui, "Enter the id of the group for checkout"));
                Group gruposel = _gui.directory().groups().get(idg);
                String texto = "The cost of group is" + gruposel.bill() + "\n";
                HashMap<Long, Guest> miembros = gruposel.members();
                for (Map.Entry<Long, Guest> entry2 : miembros.entrySet()) {
                    Long key2 = entry2.getKey();
                    Guest value2 = entry2.getValue();
                    texto = texto.concat("The member " + value2.name() + " has a consumpt of " + value2.bill() + "\n");
                    File archivo = new File("src/sources/" + gruposel.id() + ".txt");
                    if (!archivo.exists()) {
                        try {
                            archivo.createNewFile();
                            BufferedWriter writer = Utils.write(archivo);
                            writer.write(texto);
                            writer.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    _gui.directory().groups().remove(idg);
                    this.update();


                    JOptionPane.showMessageDialog(_gui, "The bill is saved in the id of the group.txt", "Bill", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (Exception Ignored) {
            }

        }
        if (event.getSource() == checkroom){
            JFrame f= new JFrame();
            JDialog d = new JDialog(f , "Dialog Restaurant", true);
            d.setLayout(null);
            DefaultListModel<String> aa3 = new DefaultListModel<>();
            HashMap<Long, Room> platos= _gui.directory().hotel().rooms();
            for(Map.Entry<Long, Room> entry : platos.entrySet()) {
                Long key = entry.getKey();
                Room value = entry.getValue();
                aa3.addElement(key +" con precio de "+value.price());
            }
            JList<String> grupos2 = new JList<String>(aa3);
            JScrollPane scrollpane = new JScrollPane(grupos2);
            scrollpane.setBounds(0, 0, 500, 200);
            scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            f.add(scrollpane);
            f.setSize(700,300);
            f.setVisible(true);
        }


    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }
}