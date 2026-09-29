INSERT INTO tenant(code,name,active) VALUES
('SI','Information Systems',TRUE),
('IF','Informatics',TRUE),
('SD','Data Science',TRUE);

INSERT INTO laboratory(tenant_code,code,name,capacity,location,active) VALUES
('SI','LAB-SI-201','Information Systems Lab 201',40,'Building A',TRUE),
('IF','LAB-IF-301','Informatics Lab 301',45,'Building B',TRUE),
('SD','LAB-SD-401','Data Science Lab 401',35,'Building C',TRUE);
