package com.bank.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bank.model.BankAccount;

@Repository
public class JdbcAccountRepository implements AccountRepository {

	private final Connection conn;

	public JdbcAccountRepository(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean createAccount(BankAccount acc) {

		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO bank_accounts (account_number, customer_name, account_type, balance, status) VALUES (?,?,?,?,?)");

			ps.setString(1, acc.getAccountNumber());
			ps.setString(2, acc.getCustomerName());
			ps.setString(3, acc.getAccountType());
			ps.setDouble(4, acc.getBalance());
			ps.setString(5, acc.getStatus());

			int row = ps.executeUpdate();
			return row > 0;

		} catch (SQLException e) {
			throw new RuntimeException("Failed to create bank account", e);
		}
	}

	@Override
	public BankAccount findByAccountNumber(String accountNumber) {

		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT account_number, customer_name, account_type, balance, status FROM bank_accounts WHERE account_number=?");

			ps.setString(1, accountNumber);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				BankAccount bA = new BankAccount();
				bA.setAccountNumber(rs.getString("account_number"));
				bA.setCustomerName(rs.getString("customer_name"));
				bA.setAccountType(rs.getString("account_type"));
				bA.setBalance(rs.getDouble("balance"));
				bA.setStatus(rs.getString("status"));

				return bA;
			}

			return null;

		} catch (SQLException e) {
			throw new RuntimeException("Failed to find account", e);
		}
	}

	@Override
	public boolean updateAccount(BankAccount a) {

		try {

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE bank_accounts SET customer_name=?, account_type=?, balance=?, status=? WHERE account_number=?");

			ps.setString(1, a.getCustomerName());
			ps.setString(2, a.getAccountType());
			ps.setString(3, a.getAccountType());
			ps.setDouble(3, a.getBalance());
			ps.setString(4, a.getStatus());
			ps.setString(5, a.getAccountNumber());

			int rows = ps.executeUpdate();

			return rows > 0;

		} catch (SQLException e) {
			throw new RuntimeException("Failed to update bank account", e);
		}
	}

	@Override
	public boolean deleteAccount(String accountNumber) {

		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM bank_accounts WHERE account_number=?");

			ps.setString(1, accountNumber);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new RuntimeException("Failed to detelet bank account " + e);
		}

	}

}
