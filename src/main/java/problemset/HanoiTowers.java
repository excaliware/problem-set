package problemset;

class HanoiTowers {
	HanoiTowers() {
		move(1, 2, 3, 40);
		System.out.printf("Disks have been moved.\n");
	}

	void move(int src, int dest, int temp, int n) {
		if (n == 1) {
			System.out.printf("Moving a disk from %d to %d\n", src, dest);
			return;
		}
		move(src, temp, dest, n-1);
		move(src, dest, temp, 1);
		move(temp, dest, src, n-1);
	}
}
