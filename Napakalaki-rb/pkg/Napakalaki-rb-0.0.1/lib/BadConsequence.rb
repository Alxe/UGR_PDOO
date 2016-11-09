#encoding: utf-8

class BadConsequence
  attr_accessor :text, :levels, :nVisibleTreasures, :nHiddenTreasures,
    :death, :specificVisibleTreasures, :specificHiddenTreasures

  private_class_method :new
  
  def initialize(text, levels, nVisibleTreasures, nHiddenTreasures, death, specificVisibleTreasures, specificHiddenTreasures)
    @text = text
    @levels = levels
    @nVisibleTreasures = nVisibleTreasures
    @nHiddenTreasures = nHiddenTreasures
    @death = death
    @specificVisibleTreasures = specificVisibleTreasures
    @specificHiddenTreasures = specificHiddenTreasures
  end
  
  def self.new_level_num_treasures(text, levels, nVisibleTreasures, nHiddenTreasures)
    new(text, levels, nVisibleTreasures, nHiddenTreasures, false, Array.new, Array.new)
  end
  
  def self.new_level_specific_treasures(text, levels, specificVisibleTreasures, specificHiddenTreasures)
    new(text, levels, 0, 0, false, specificVisibleTreasures, specificHiddenTreasures)
  end
  
  def self.new_death(text)
    new(text, 0, 0, 0, true, Array.new, Array.new)
  end
  
  def to_s
    "BadConsequence{text=#{@text}, levels=#{@levels}, nVisibleTreasures=#{@nVisibleTreasures}, nHiddenTreasures=#{@nHiddenTreasures}, death=#{@death}, specificVisibleTreasure=#{@specificVisibleTreasures}, specificHiddenTreasures=#{@specificHiddenTreasures}}"
  end
end