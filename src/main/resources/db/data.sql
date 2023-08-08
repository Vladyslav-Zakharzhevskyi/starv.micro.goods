CREATE OR REPLACE FUNCTION generate_sku() RETURNS text AS
'
BEGIN
    RETURN ''SK-'' || UPPER(pg_catalog.substring(gen_random_uuid()::text, 1, 7));
END;
'
    LANGUAGE plpgsql;

insert into goods(name, description, sku)
values
    ('Smartphone Nova X-9R2', 'Experience the Smartphone Nova X-9R2, a smart device with exceptional performance and camera capabilities.', 'SK-4C484C8'),
    ('LaptopJet Pro', 'The LaptopJet Pro is a powerful and compact laptop, perfect for your everyday tasks.', 'SK-E5F7056'),
    ('VR Glasses Mirage V-12T', 'Dive into a world of excitement with VR Glasses Mirage V-12T, providing an immersive virtual reality experience.', 'SK-CBB1F6C'),
    ('Camera SnapShot G-3H6', 'Capture life''s important moments with Camera SnapShot G-3H6, a top-notch camera.', 'SK-71FF221'),
    ('Electric Scooter Zingy M-2P1', 'Move swiftly and sustainably through the city on Electric Scooter Zingy M-2P1.', 'SK-AC2FC5C'),
    ('Wireless EarBuds AeroWave E-8D2', 'Embrace the convenience of wire-free music with Wireless EarBuds AeroWave E-8D2.', 'SK-D466861'),
    ('RoboDust', 'Set yourself free from cleaning with RoboDust, an autonomous robot vacuum.', 'SK-BA6FE00'),
    ('Projector StarBurst P-4G5', 'Transform your space into a home theater with Projector StarBurst P-4G5, a high-quality and cinematic device.', 'SK-EDB221B'),
    ('Smartwatch TimeSync X-7K4', 'Description: Stay on top of your schedule and health with Smartwatch TimeSync X-7K4.', 'SK-9BC510E');

