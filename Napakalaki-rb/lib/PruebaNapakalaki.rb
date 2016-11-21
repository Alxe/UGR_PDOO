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
    
  ]
  #end init
end

PruebaNapakalaki::main