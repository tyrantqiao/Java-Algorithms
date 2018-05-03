package pattern;

/**
 * date: 2018/4/30
 * Description: 抽象工厂模式，通过一个工厂生成各种工厂
 * blog https://tyrantqiao.github.io/Blog
 *
 * @author tyrantqiao
 * @version 0.0.1
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class AbstractFactoryPattern {
	/**
	 * shape接口
	 */
	interface Shape {
		/**
		 * paint方法
		 */
		void paint();
	}

	/**
	 * color接口
	 */
	interface Color {
		/**
		 * paint()
		 */
		void paint();
	}

	class Square implements Shape {

		@Override
		public void paint() {
			System.out.println("square");
		}
	}

	/**
	 * 超级工厂(大抽象的工厂)
	 */
	abstract class AbstractFactory {
		abstract Shape getShape(String shape);

		abstract Color getColor(String color);
	}

	/**
	 * 这里应该是类为非静态，而方法为静态的，估计是因为内部类过多的缘故。
	 */
	class FactoryProducer {
		public AbstractFactory getFactory(String factoryType) {
			if (factoryType == "ShapeFactory") {
				return new ShapeFactory();
			}
			return null;
		}
	}

	class ShapeFactory extends AbstractFactory {

		@Override
		Shape getShape(String shape) {
			return new Square();
		}

		@Override
		Color getColor(String color) {
			return null;
		}
	}
}
