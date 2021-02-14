package org.broughtmiracles.kiwi.store.instore.stack.database;

import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.*;
import java.util.Arrays;

@UtilityClass
public class StackDBUtil {

    private final static String BALANCE_SQL = "SELECT BALANCE FROM hyper_database WHERE PLAYER = ?";
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static Connection connection = null;



    public int getBalance(Player player) throws SQLException, ClassNotFoundException {
        try (

                Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hypercraft?useSSL=false", "root", "5123");
             PreparedStatement preparedStatement = connection.prepareStatement(BALANCE_SQL);
        ) {
            int balance = 0;

            preparedStatement.setString(1, player.getName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                balance = resultSet.getInt("BALANCE");
            }

            return balance;
        } catch (Exception exception) {
            return 0;
        }
    }
    public void buy(Player player, int amount, Material material) throws ClassNotFoundException, SQLException {
        try  ( Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hypercraft?useSSL=false", "root", "5123");
              PreparedStatement preparedStatement = connection.prepareStatement("UPDATE hyper_database SET BALANCE = ? WHERE PLAYER = ? ");
        ){
            Class.forName("com.mysql.jdbc.Driver");

            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, player.getName());
            preparedStatement.executeUpdate();

            player.getInventory().addItem(new ItemStack(material));
            player.sendMessage("Вы успешно купили: " + material.name());
            player.sendMessage("У вас осталось: " + getBalance(player) + " монет");
        } catch (Exception exception) {
            player.sendMessage("Недостаточно средств на балансе.");
        }
    }

    public void killSetBalance(Player player, int amount, Entity entity) throws ClassNotFoundException, SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hypercraft", "root", "5123");

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE hyper_database SET BALANCE = ? WHERE PLAYER = ?; ");
        ) {
            Class.forName("com.mysql.jdbc.Driver");

            preparedStatement.setInt(1, getBalance(player) + amount);
            preparedStatement.setString(2, player.getName());

            preparedStatement.executeUpdate();

            player.sendMessage("Вы убили: " + entity.getName() + "\nВы получили за это: " + amount + " монет");
            player.sendMessage("Ваш баланс: " + getBalance(player));


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
