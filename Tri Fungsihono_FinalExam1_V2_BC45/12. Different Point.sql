USE Unicorn;

SELECT 
	maj.[Name] AS [Major Name],
	maj.TotalCreditPoint [Total Credit Point],
	(maj.TotalCreditPoint - SUM(sub.CreditPoint)) AS [Different with subject]
FROM dbo.Major AS maj
	JOIN dbo.[Subject] AS sub ON maj.ID=sub.MajorID
GROUP BY maj.[Name],
	maj.TotalCreditPoint;