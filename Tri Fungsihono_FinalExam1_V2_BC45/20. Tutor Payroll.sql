USE Unicorn;

SELECT tut.StaffNumber AS [StaffNumber],
	CONCAT_WS(' ',tut.FirstName,tut.MiddleName,tut.LastName) AS [Employee Full name],
	(CASE WHEN tut.EmployeeType = 'FC'
			THEN 'Full-Time Contract'
		WHEN tut.EmployeeType = 'FP'
			THEN 'Full-time Permanent'
		WHEN tut.EmployeeType = 'PC'
			THEN 'Part-time Contract'
		WHEN tut.EmployeeType = 'CA'
			THEN 'Casual'
		ELSE ''
		END) AS [Employee Type],
	(tut.BasicSalary + ((tut.BasicSalary * Allowance)/100)) AS [Take Homepay]
FROM dbo.Tutor AS tut;