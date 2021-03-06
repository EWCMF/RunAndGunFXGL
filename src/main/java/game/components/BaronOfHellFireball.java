package game.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import game.RunAndGunFXGLTypes;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

import java.util.List;
import java.util.stream.Collectors;

public class BaronOfHellFireball extends Component {
    @Override
    public void onAdded() {
        if (!entity.isType(RunAndGunFXGLTypes.PURPLEBOHEXPLOSION)) {
            double minX = entity.getX();
            double minY = entity.getY();
            int damage = entity.getProperties().getInt("damage");
            Rectangle2D selection = new Rectangle2D(minX, minY, 150, 150);
            List<Entity> list = FXGL.getGameWorld().getEntitiesInRange(selection).stream()
                    .filter(e -> e.isType(RunAndGunFXGLTypes.PLAYER)).collect(Collectors.toList());

            if (!list.isEmpty()) {
                list.get(0).getComponent(PlayerComponent.class).onHit(damage, new Point2D(-1, 0));
                list.get(0).getComponent(FlickerComponent.class).flicker();
            }
        }
        else {
            double minX = entity.getX();
            double minY = entity.getY();
            int damage = entity.getProperties().getInt("damage");
            Rectangle2D selection = new Rectangle2D(minX, minY, 200, 200);
            List<Entity> list = FXGL.getGameWorld().getEntitiesInRange(selection).stream()
                    .filter(e -> e.isType(RunAndGunFXGLTypes.PLAYER)).collect(Collectors.toList());

            if (!list.isEmpty()) {
                list.get(0).getComponent(PlayerComponent.class).onHit(damage, new Point2D(-1, 0));
                list.get(0).getComponent(FlickerComponent.class).flicker();
            }
        }

    }
}
