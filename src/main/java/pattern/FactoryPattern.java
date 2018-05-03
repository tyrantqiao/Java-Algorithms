package pattern;

/**
 * date: 2018/4/30
 * Description: 工厂模式
 * blog https://tyrantqiao.github.io/Blog
 *
 * @author tyrantqiao
 * @version 0.0.1
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class FactoryPattern {
	/**
	 * 基础接口
	 */
	interface Shape {
		/**
		 * 接口内的方法paint
		 */
		void paint();
	}

	class Circle implements Shape {

		@Override
		public void paint() {
			System.out.println("circle shape");
		}
	}

	public Shape getShape(String shapeType) {
		if (shapeType == "circle") {
			return new Circle();
		}
		return null;
	}
}
