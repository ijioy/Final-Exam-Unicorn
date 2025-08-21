USE Unicorn;

CREATE FUNCTION  IncomeFromFee (@Day AS INT)
RETURNS TABLE AS RETURN
BEGIN
	SELECT stu.StudentNumber,
		(SUM(enr.fee) + SUM(sub.Cost)) AS [Total Cost]
	FROM dbo.Student AS stu
		JOIN dbo.StudentMajor AS sm ON stu.StudentNumber=sm.StudentNumber
		JOIN dbo.Major AS maj ON sm.MajorID=maj.ID
		join dbo.Subject AS sub ON maj.ID=sub.MajorID
		JOIN dbo.Competency AS com ON sub.ID=com.SubjectID
		JOIN dbo.Period AS per ON com.ID=per.CompetencyID
		JOIN dbo.Enrollment AS enr ON per.ID=enr.PeriodID
	WHERE sm.SetDate BETWEEN stu.RegisterDate AND (DAY(per.EndDate)=@Day)
	GROUP BY stu.StudentNumber
END