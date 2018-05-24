public abstract class Weapon {
	int clipSize, totalAmmo, currentAmmo;
	double reloadTime, fireRate;
	
	abstract void reload();
	abstract Projectile[] fire();
	
}
