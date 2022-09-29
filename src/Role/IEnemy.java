package Role;

public interface IEnemy {
	void getIntend();
	void EnemyTurn(Role Enemy, Role Player);
	String getIntendContent(Enemy tmp);
}
