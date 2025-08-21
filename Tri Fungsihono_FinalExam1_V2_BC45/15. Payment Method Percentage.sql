USE Unicorn;

SELECT (CASE WHEN enr.PaymentMethod = 'AC'
				THEN 'Auto Collection'
			WHEN enr.PaymentMethod = 'CC'
				THEN 'Credit Card'
			WHEN enr.PaymentMethod = 'CH'
				THEN 'Cheque'
			WHEN enr.PaymentMethod = 'BT'
				THEN 'Bank Transfer'
			END) AS [Payment Method],
		(CAST(COUNT(*) AS INT))
FROM dbo.Enrollment AS enr
GROUP BY enr.PaymentMethod;