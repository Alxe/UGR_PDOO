#encoding: utf-8

require_relative 'TreasureKind.rb'
require_relative 'Monster.rb'

module PruebaNapakalaki
  
  def self.monstruos_con_nivel_mayor_a_diez
    @@monstruos.select { |m| m.combatLevel > 10 }
  end
  
  def self.monstruos_con_mal_rollo_niveles
    @@monstruos.select { |m| 
      m.bc.nVisibleTreasures == 0 and
        m.bc.nHiddenTreasures == 0 and
        m.bc.specificVisibleTreasures.empty? and
        m.bc.specificHiddenTreasures.empty?
    }
  end
  
  def self.monstruos_con_mal_rollo_de_nivel_uno
    @@monstruos.select { |m|
      m.prize.level > 1
    }
  end
  
  def self.monstruos_consulta_4(treasure_kind)
    @@monstruos.select { |m|
      m.bc.specificVisibleTreasures.include?(treasure_kind) or
        m.bc.specificHiddenTreasures.include?(treasure_kind)
    }
  end

  def self.main
    puts monstruos_consulta_4(TreasureKind::ARMOR)
    return nil
    print monstruos_con_nivel_mayor_a_diez
    print monstruos_con_mal_rollo_niveles
    print monstruos_con_mal_rollo_de_nivel_uno
    print monstruos_consulta_4(TreasureKind::ONEHAND)
    print monstruos_consulta_4(TreasureKind::BOTHHANDS)
    print monstruos_consulta_4(TreasureKind::HELMET)
    print monstruos_consulta_4(TreasureKind::SHOES)
    print monstruos_consulta_4(TreasureKind::ARMOR)
  end
  
  #start init
  @@monstruos = [
    Monster.new("3 Byakhees de bonanza", 8,
            Prize.new(2, 1), 
            BadConsequence.new_level_specific_treasures("Pierdes tu armadura visible y otra oculta", 0, 
              [TreasureKind::ARMOR], [TreasureKind::ARMOR])),

    Monster.new("Tenochtitlan", 2,
            Prize.new(1, 1),
            BadConsequence.new_level_specific_treasures("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
              [TreasureKind::HELMET], [])),

    Monster.new("El sopor de Dunwich", 2,
            Prize.new(1, 1),
            BadConsequence.new_level_specific_treasures("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
                    [TreasureKind::SHOES], [])),

    Monster.new("Demonios de Magaluf", 2,
            Prize.new(4, 1),
            BadConsequence.new_level_num_treasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, 1, 1)),

    Monster.new("El gorrón en el umbral", 13,
            Prize.new(3, 1),
            BadConsequence.new_level_num_treasures("Pierdes todos tus tesoros visibles", 0, 0, 0)),

    Monster.new("H.P. Munchcraft", 6, 
            Prize.new(2, 1), 
            BadConsequence.new_level_specific_treasures("Pierdes la armadura visible", 0,
                    [TreasureKind::ARMOR], [])),

    Monster.new("Necrófago", 13, 
            Prize.new(1, 1), 
            BadConsequence.new_level_specific_treasures("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, 
                    [TreasureKind::ARMOR], [])),

    Monster.new("El rey de rosado", 11, 
            Prize.new(3, 2), 
            BadConsequence.new_level_num_treasures("Pierdes 5 niveles de 3 tesoros visibles", 5, 3, 0)),

    Monster.new("Flecher", 2, 
            Prize.new(1, 1), 
            BadConsequence.new_level_num_treasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)),

    Monster.new("Los hondos", 8, 
            Prize.new(2, 1), 
            BadConsequence.new_death("Estos monstruos resultan bastantes superficiales y te aburren mortalmente. Estas muerto")),

    Monster.new("Semillas Cthulhu", 4, 
            Prize.new(2, 1), 
            BadConsequence.new_level_num_treasures("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2)),

    Monster.new("Dameargo", 1, 
            Prize.new(2, 1), 
            BadConsequence.new_level_specific_treasures("Te intentas escaquear. Pierdes una mano visible.", 0,
              [TreasureKind::ONEHAND], [])),

    Monster.new("Pollipólipo volante", 3, 
            Prize.new(2, 1), 
            BadConsequence.new_level_num_treasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)),

    Monster.new("Yskhtihyssg-Goth", 14, 
            Prize.new(3, 1), 
            BadConsequence.new_death("No le hace gracia que pronuncien mal su nombre. Estas muerto")),

    Monster.new("Familia feliz", 1, 
            Prize.new(3, 1), 
            BadConsequence.new_death("La familia te atrapa. Estás muerto.")),

    Monster.new("Roboggoth", 8, 
            Prize.new(2, 1), 
            BadConsequence.new_level_specific_treasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
              [TreasureKind::BOTHHANDS], [])),

    Monster.new("El espía sordo", 5, 
            Prize.new(1, 1), 
            BadConsequence.new_level_specific_treasures("Te asusta en la noche", 0,
              [TreasureKind::HELMET], [])),

    Monster.new("Tongue", 19, 
            Prize.new(2, 1), 
            BadConsequence.new_level_num_treasures("Menudo susto te llevas", 2, 5, 0)),

    Monster.new("Bicéfalo", 21, 
            Prize.new(2, 1), 
            BadConsequence.new_level_num_treasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, 100000, 0)),
  ]
  #end init
end

PruebaNapakalaki::main