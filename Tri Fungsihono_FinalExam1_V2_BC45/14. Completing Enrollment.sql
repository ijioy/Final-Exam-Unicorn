USE Unicorn;

ALTER PROCEDURE dbo.PurchaseNew
	@ID AS INT, 
	@PaymentMethod AS VARCHAR(200)
AS
BEGIN
    DECLARE @CurrentStatus VARCHAR(50);
    DECLARE @Cost MONEY;
    DECLARE @SubjectCost DECIMAL(18, 2);

    BEGIN TRANSACTION;
		SELECT @CurrentStatus = enr.[Status],
			@Cost = SUM(sub.Cost)
		FROM dbo.Student AS stu
			JOIN dbo.city AS cit ON stu.BirthCityID=cit.ID
			JOIN dbo.StudentMajor AS sm ON stu.StudentNumber=sm.StudentNumber
			JOIN dbo.Major AS maj ON sm.MajorID=maj.ID
			JOIN dbo.[Subject] AS sub ON maj.ID=sub.MajorID
			JOIN dbo.Enrollment AS enr ON stu.StudentNumber=enr.StudentNumber
		WHERE enr.ID = @ID
		GROUP BY enr.[Status];

		IF @CurrentStatus = 'COM'
			BEGIN
				ROLLBACK TRANSACTION;
				PRINT 'Transaksi sudah complete sejak awal.';
			END
		ELSE IF @CurrentStatus = 'CAN'
			BEGIN
				ROLLBACK TRANSACTION;
				PRINT 'Transaksi sudah dalam kondisi cancel, tidak bisa dibayar.';
			END
		ELSE IF @CurrentStatus = 'PEN'
			BEGIN
				
				UPDATE dbo.Enrollment
				SET
					Status = 'COM',
					TransactionDate = GETDATE(), 
					PaymentMethod = @PaymentMethod,
					Fee = @Cost 
				WHERE
					ID = @ID;
				COMMIT TRANSACTION;
			END
END

EXECUTE dbo.PurchaseNew @ID = 3, @PaymentMethod = 'AC';
