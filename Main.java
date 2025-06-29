
import java.awt.*;
import javax.swing.*;

class BackgroundPanel extends JPanel {

    private final Image backgroundImage;
    private final Image cookieImage;
    public BackgroundPanel(String bgPath, String cookiePath) {
        backgroundImage = new ImageIcon(bgPath).getImage();
        cookieImage = new ImageIcon(cookiePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        int cookieWidth = 250, cookieHeight = 150;
        int x = (getWidth() - cookieWidth) / 2;
        int y = 50;
        g.drawImage(cookieImage, x, y, cookieWidth, cookieHeight, this);
    }
}

class RoundedButton extends JButton {

    private final int radius;
    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0, 102, 204, 180));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, radius, radius);
        g2.dispose();
    }
}

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fortune Cookie App");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPanel panel = new BackgroundPanel("C:\\Users\\Yukesh\\Documents\\VS Code\\Fortune Cookie App\\Background.jpg", "C:\\Users\\Yukesh\\Documents\\VS Code\\Fortune Cookie App\\Cookie.png");
        panel.setLayout(new BorderLayout());

        JLabel fortuneLabel = new JLabel("✨ Click the button to crack the cookie!", SwingConstants.CENTER);
        fortuneLabel.setFont(new Font("Serif", Font.BOLD, 40));
        fortuneLabel.setForeground(Color.BLUE);
        panel.add(fortuneLabel, BorderLayout.CENTER);

        RoundedButton button = new RoundedButton("Crack!", 30);
        button.setFont(new Font("Serif", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(120, 50));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        buttonPanel.add(button);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        String[] fortunes = {
            "Adventure awaits you this weekend.",
            "You will make a new friend today.",
            "A pleasant surprise is in store for you.",
            "Happiness begins with facing life with a smile.",
            "Your hard work will soon pay off.",
            "Adventure awaits you this weekend.",
            "You will make a new friend today.",
            "A pleasant surprise is in store for you.",
            "Happiness begins with facing life with a smile.",
            "Your hard work will soon pay off.",
            "A new opportunity will present itself soon.",
            "You will discover a hidden talent.",
            "Your kindness will lead you to success.",
            "Good news is on its way to you.",
            "You will soon receive the recognition you deserve.",
            "Something lost will soon be found.",
            "An exciting journey is in your future.",
            "Today is a perfect day to start something new.",
            "You will inspire someone close to you.",
            "Trust your instincts; they will guide you well.",
            "A small act of generosity will bring big rewards.",
            "You are stronger than you think.",
            "A dream you have will soon come true.",
            "Your creativity will open unexpected doors.",
            "Someone will share good advice with you today.",
            "You will find joy in an unexpected place.",
            "Your efforts will bring lasting happiness.",
            "Good fortune is smiling upon you.",
            "Stay positive; amazing things are coming.",
            "A wish you make today will soon be fulfilled.",
            "A challenge you face now will make you stronger.",
            "Patience will bring you a great reward.",
            "An old friend will reach out to you soon.",
            "You will find beauty in the simplest things.",
            "Your courage will inspire those around you.",
            "Unexpected kindness will brighten your day.",
            "A new perspective will open doors for you.",
            "Luck will find you when you least expect it.",
            "Your talents will be recognized by others.",
            "Small steps today lead to big victories tomorrow.",
            "Someone you admire thinks highly of you.",
            "A happy event will make your week special.",
            "Your positive attitude will attract new opportunities.",
            "Your honesty will earn you great respect.",
            "A peaceful moment will bring clarity to your mind.",
            "Trust that good things are on the horizon.",
            "Your determination will overcome any obstacle.",
            "An exciting idea will spark your imagination.",
            "A secret wish you have will soon be granted.",
            "Your heart will guide you to the right path."

        };
        button.addActionListener(e -> {
            int randomIndex = (int) (Math.random() * fortunes.length);
            fortuneLabel.setText("✨ " + fortunes[randomIndex]);
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
